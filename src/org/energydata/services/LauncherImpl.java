package org.energydata.services;



import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.energydata.beans.Appliance;
import org.energydata.beans.Factory;
import org.energydata.beans.HouseHold;
import org.energydata.beans.Measure;
import org.energydata.dao.DAOFactory;


public class LauncherImpl implements Launcher {
	
	private DAOFactory daoFactory = DAOFactory.getInstance();
   

	
	@Override
	public Map<Integer, Double> getTotalConsumeEachHouseHold() {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		HashMap<Integer, Double> tmp = new HashMap<Integer, Double>();

		try {
			connect = daoFactory.getConnection();
			preparedStatement = connect.prepareStatement("SELECT h.idhousehold,sum(m.energyvalue) as Total FROM household h,appliance a, sensor s, measure m WHERE h.idhousehold=s.idhousehold and a.idappliance=s.idappliance and s.idsensor = m.idsensor group by h.idhousehold");

			//		.prepareStatement("SELECT h.idhousehold,sum(m.energyvalue) as Total FROM household h,appliance a, sensor s, measure m WHERE h.idhousehold=s.idhousehold and a.idappliance=s.idappliance and s.idsensor = m.idsensor where m.dateMeasure between(?,?) group by h.idhousehold");
					
		//	Timestamp ts1 = new Timestamp(start.getTime());
		//	Timestamp ts2 = new Timestamp(fin.getTime());

		//	preparedStatement.setTimestamp(1, ts1);
		//	preparedStatement.setTimestamp(2, ts2);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				int idAppliance = rs.getInt(1);

				Double total = rs.getDouble(2);

				tmp.put(idAppliance, total);

			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		return tmp;

	}
	
	@Override
	public Map<Integer, Double> getHouseHoldMostConsume() {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		HashMap<Integer, Double> tmp = new HashMap<Integer, Double>();

		try {
			connect = daoFactory.getConnection();
			preparedStatement = connect
					.prepareStatement("SELECT h.idhousehold as idHouseHold, sum(m.energyvalue) as Total FROM household h,appliance a, sensor s, measure m WHERE h.idhousehold=s.idhousehold and a.idappliance=s.idappliance and s.idsensor = m.idsensor group by h.idhousehold order by sum(m.energyvalue) desc");

	

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {

				int idHouseHold = rs.getInt(1);

				Double total = rs.getDouble(2);

				tmp.put(idHouseHold, total);

			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		return tmp;

	}
	
	@Override
	public Map<Integer, Double> getHouseHoldLeastConsume() {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		HashMap<Integer, Double> tmp = new HashMap<Integer, Double>();

		try {
			connect = daoFactory.getConnection();
			preparedStatement = connect
					.prepareStatement("SELECT  h.idhousehold as idHouseHold, sum(m.energyvalue) as Total FROM household h,appliance a, sensor s, measure m WHERE h.idhousehold=s.idhousehold and a.idappliance=s.idappliance and s.idsensor = m.idsensor group by h.idhousehold order by sum(m.energyvalue);");

	
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {

				int idHouseHold = rs.getInt(1);

				Double total = rs.getDouble(2);

				tmp.put(idHouseHold, total);

			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		return tmp;

	}
	

	@Override
	public Map<Appliance, Double> getTotalConsumeEachAppliance() {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		HashMap<Appliance, Double> tmp = new HashMap<Appliance, Double>();

		try {
			connect = daoFactory.getConnection();
			preparedStatement = connect
					.prepareStatement("SELECT a.idappliance,a.appliancename,a.applianceunit,sum(m.energyvalue) FROM appliance a, sensor s, measure m WHERE  a.idappliance=s.idappliance and s.idsensor = m.idsensor group by (a.idappliance,a.appliancename,a.applianceunit)");

	

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				int idAppliance = rs.getInt(1);
                String applianceName = rs.getString(2);
                String applianceUnit = rs.getString(3);
               	Double total = rs.getDouble(3);
                Appliance a=Factory.createAppliance(applianceName);
                a.setIdAppliance(idAppliance);
                a.setApplianceUnit(applianceUnit);
				tmp.put(a, total);

			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		return tmp;

	}
	
	@Override
	public Map<Appliance, Double> getApplianceMostConsume() {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		HashMap<Appliance, Double> tmp = new HashMap<Appliance, Double>();

		try {
			connect = daoFactory.getConnection();
			preparedStatement = connect
					.prepareStatement("SELECT a.idappliance,a.appliancename,a.applianceunit,sum(m.energyvalue) FROM appliance a, sensor s, measure m WHERE  a.idappliance=s.idappliance and s.idsensor = m.idsensor group by (a.idappliance,a.appliancename,a.applianceunit) order by sum(m.energyvalue) desc");

	

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {

				int idAppliance = rs.getInt(1);
                String applianceName = rs.getString(2);
                String applianceUnit = rs.getString(3);
               	Double total = rs.getDouble(4);
                Appliance a=Factory.createAppliance(applianceName);
                a.setIdAppliance(idAppliance);
                a.setApplianceUnit(applianceUnit);
				tmp.put(a, total);

			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		return tmp;

	}
	
	@Override
	public Map<Appliance, Double> getApplianceLeastConsume() {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		HashMap<Appliance, Double> tmp = new HashMap<Appliance, Double>();

		try {
			connect = daoFactory.getConnection();
			preparedStatement = connect
					.prepareStatement("SELECT a.idappliance,a.appliancename,a.applianceunit,sum(m.energyvalue) FROM appliance a, sensor s, measure m WHERE  a.idappliance=s.idappliance and s.idsensor = m.idsensor group by (a.idappliance,a.appliancename,a.applianceunit) order by sum(m.energyvalue)");

	

			ResultSet rs = preparedStatement.executeQuery();

			if(rs.next()) {

				int idAppliance = rs.getInt(1);
                String applianceName = rs.getString(2);
                String applianceUnit = rs.getString(3);
               	Double total = rs.getDouble(4);
                Appliance a=Factory.createAppliance(applianceName);
                a.setIdAppliance(idAppliance);
                a.setApplianceUnit(applianceUnit);
				tmp.put(a, total);


			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		return tmp;

	}
 
	@Override
	public Map<String, Double> getMostConsumeDate() {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		HashMap<String, Double> tmp = new HashMap<String, Double>();

		try {
			connect = daoFactory.getConnection();
			preparedStatement = connect
					.prepareStatement("SELECT TO_CHAR(m.datemeasure, 'DD-MON-YYYY'),sum(m.energyvalue)FROM measure m group by (TO_CHAR(m.datemeasure, 'DD-MON-YYYY')) order by sum(m.energyvalue) desc");

	

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				String dateStr = rs.getString(1);

				Double total = rs.getDouble(2);

				tmp.put(dateStr, total);
				
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		return tmp;

	}
	
	@Override
	public void LoadFileByFile(String fileName){
		
        File fichier = new File(fileName);
		
		DataLoader dataLoader = new DataLoaderFileImpl(fichier);
		DataStorage dataStorage = new DataStorageDBImpl();
		dataStorage.save(dataLoader);	
	
	}
	
	
	
	
	
	@Override
	public void LoadFileByDiectory(String directoryName){
		
		File listOfFile = new File(directoryName);
		if(listOfFile.isDirectory()){
			for(String fichier : listOfFile.list()){
				System.out.println("Fichier: "+fichier);
				DataLoader dataLoader = new DataLoaderFileImpl(new File(listOfFile.getAbsolutePath()+"/"+fichier));
				DataStorage dataStorage = new DataStorageDBImpl();
				dataStorage.save(dataLoader);
				
			}
		}		
		
	}
	
	
	public static void main(String args[]){	
		System.out.println("Debut du programme");
		
		//long begintime = System.nanoTime();
         
		
		String dataSourceDirectory = "data/RawData";

		//String dataSource = "data/RawData/1000080-2000903-3009932.txt";
		//String dataSource = "data/RawData/1000080-2000903-3009929.txt";
		//String dataSource = "data/RawData/1000080-2000900-3009906.txt";
		
		LauncherImpl launcher = new LauncherImpl();
		
//		laucher.LoadFileByFile(dataSource);
		launcher.LoadFileByDiectory(dataSourceDirectory);
		
//		Map<Appliance, Double> tmp=launcher.getTotalConsumeEachAppliance();
//		
//		Iterator<Entry<Appliance, Double>> it = tmp.entrySet().iterator();
//
//		  while (it.hasNext()) {
//		   Entry<Appliance, Double> e =it.next();
//		   
//		   Appliance key = e.getKey();
//		   double value= e.getValue();
//
//		   System.out.println("key= id " + key.getIdAppliance() + " name " + key.getApplianceName() + " unit "+key.getApplianceUnit()+ " value=" + value);
//		  }
//		
//		System.out.println("Programme termine");
		// long endtime = System.nanoTime();
		// long costTime = (endtime - begintime)/1000000000;
		 
		//System.out.println("This action was during : " + costTime + "s");
		
		
		
		
		
	}
	
	

}
