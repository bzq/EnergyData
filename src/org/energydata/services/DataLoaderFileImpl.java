package org.energydata.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.energydata.beans.Appliance;
import org.energydata.beans.Factory;
import org.energydata.beans.HouseHold;
import org.energydata.beans.Measure;
import org.energydata.beans.Sensor;
import org.energydata.dao.ApplianceDao;
import org.energydata.dao.DAOFactory;
import org.energydata.dao.HouseHoldDao;
import org.energydata.dao.MeasureDao;
import org.energydata.dao.MeasureDaoImpl;
import org.energydata.dao.SensorDao;



/**
 *
 * @author bingzhi
 */
public class DataLoaderFileImpl  implements DataLoader{

	private DAOFactory daoFactory;
	
	private Sensor sensor;
	private HouseHold houseHold;
	private Appliance appliance;
	private List<Measure> listMeasures;
	
	private boolean add(Measure e) {
		return listMeasures.add(e);
	}

	public DataLoaderFileImpl(File file){
		listMeasures = new ArrayList<Measure>();
		FileReader fr=null;

		try {
			fr = new FileReader(file);
			daoFactory = DAOFactory.getInstance();
			BufferedReader br=new BufferedReader(fr);
			String line ="";

			while ((line=br.readLine())!=null) {				
				int returnValue = this.processLine(line);
			}
			br.close();
			fr.close();

		} catch (IOException ex) {
			Logger.getLogger(DataLoaderFileImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				fr.close();
			} catch (IOException ex) {
				Logger.getLogger(DataLoaderFileImpl.class.getName()).log(Level.SEVERE, null, ex);
			}
		}  
	}


	/**
	 * @param date String
	 * @param time String
	 * @return date Date
	 */
	private Date convertStringToDate(String date, String time){

		Date newDate=null;
		try {
			newDate= new SimpleDateFormat("dd/MM/yy HH:mm").parse(date+" "+time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return newDate;
	}

	/**
	 * @param date String
	 * @return boolean
	 */
	private boolean isMeasure(String date){
		Pattern p = Pattern.compile("\\d{2}/\\d{2}/\\d{2}");
		Matcher m = p.matcher(date);
		if (m.matches()){
			return true;
		}
		else{
			return false;
		}
	}

	private static Appliance extractApplianceFromApplianceName(String applianceName, HouseHold household){

		int indexParentheseOuvrante = applianceName.indexOf("(");
		String newApplianceName = applianceName.substring(0, indexParentheseOuvrante - 1).trim();
		int lastSpace = newApplianceName.lastIndexOf(" ");
		String identifySensor= newApplianceName.substring(lastSpace + 1);
		String pattern = "\\d+";
		if(!identifySensor.matches(pattern)){
			applianceName= newApplianceName;
		}
		else{
			applianceName = newApplianceName.substring(0, lastSpace).trim();
		}
		Appliance appliance = Factory.createAppliance(applianceName);
		return appliance;
	}

	private static Sensor extractSensorFromApplianceName(String applianceName, Appliance appliance, HouseHold household){
		String descriptionSensor="";
		String location="";
		int indexParentheseOuvrante = applianceName.indexOf("(");
		int indexParentheseFermante = applianceName.indexOf(")");
		if((indexParentheseFermante - indexParentheseOuvrante) > 1){
			descriptionSensor=applianceName.substring(indexParentheseOuvrante+1, indexParentheseFermante);
		}

		String newApplianceName = applianceName.substring(0, indexParentheseOuvrante - 1).trim();
		int lastSpace = newApplianceName.lastIndexOf(" ");
		String identifySensor= newApplianceName.substring(lastSpace + 1);
		int identifiantFinal=1;
		try{
			identifiantFinal=Integer.parseInt(identifySensor);
		}catch(Exception e){
		//ne pas la traiter, utile pour le cas de la consommation totale de la maison	
		}

		Sensor sensor= Factory.createSensor(identifiantFinal, appliance, household, descriptionSensor, location);
		return sensor;
	}
	
	private int processLine(String line){
		
		String[] split = line.split("\\n");

		for(int i=0;i<split.length;i++){
			String[] header = line.split(":");
			String[] data = line.split("\\t");
			if(data.length==4 && isMeasure(data[0])){
				Measure mesure;
				Date dateMeasure = this.convertStringToDate(data[0], data[1]);
				long energyValue = Long.parseLong(data[3]);
				int state = Integer.parseInt(data[2]);
				mesure= Factory.createMeasure(dateMeasure, energyValue, state, sensor);
				this.add(mesure);
			}
			else if(header[0].trim().equals("HOUSEHOLD")){
				String houseName = header[1];
				houseHold = Factory.createHouseHold(houseName);
			}
			else if(header[0].trim().equals("APPLIANCE")){
				String applianceName = header[1];
				appliance = extractApplianceFromApplianceName(applianceName, houseHold);
				sensor = extractSensorFromApplianceName(applianceName,appliance,houseHold);
			}
		}
		return 0;
		
	}


	public static void main(String args[]){

		System.out.println("Debut du programme");

		String dataSource = "Data/RawData/1000080-2000900-3009906.txt";
		DataLoader dataLoader = new DataLoaderFileImpl(new File(dataSource));

		DataStorage dataStorage = new DataStorageDBImpl();
		dataStorage.save(dataLoader);
		System.out.println("Programme termine");

	}


	public List<Measure> getMeasures() {
		return listMeasures;
	}

}
