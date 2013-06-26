package org.energydata.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import org.energydata.beans.Appliance;
import org.energydata.beans.Factory;
import org.energydata.beans.Sensor;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TestWithDate {
	
	
	
	
	
	public static void main(String args[]){
		
		
		//Date t = new Date();
		

		
	
	
		
		//String date ="29/03/98";
		//String time= "02:00";
		
        
		//DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yy HH:mm");
		//DateTime dt = formatter.parseDateTime(date+" "+time);
		
		
		//t=dt.toDate();
		//Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		
	//	SimpleDateFormat dateFormat = new SimpleDateFormat();
	//	dateFormat.applyPattern("dd/MM/yy HH:mm");
	//	dateFormat.setCalendar(calendar);
	
	/*	
		//DateFormat df =DateFormat.getDateInstance(DateFormat.SHORT);
		try {
			t=df.parse(date+" "+time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	*/	
		//System.out.println(t);
		//Date newDate=null;
	//	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");  
		
		  //SimpleTimeZone tz = new SimpleTimeZone(0, "Out Timezone");  
		 // dateFormat.setTimeZone(tz);

		//try {  
		//   newDate = dateFormat.parse(date+" "+time);  

		//} catch (ParseException e) {  
		//    e.printStackTrace();  
		//}	
		//System.out.println(newDate.toString());
		
		Launcher laun = new LauncherImpl();

		Map<Integer, Double> tmp = laun.getTotalConsumeEachHouseHold("1998/01/30", "1999/01/03");

		Iterator it = tmp.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			System.out.println("IdHouse=" + key + " value=" + value);
		}
		
		
		Map<Integer, Double> tmp1= laun.getHouseHoldMostConsume("1998/01/30", "1999/01/03");
		Iterator it1 = tmp1.entrySet().iterator();
		while (it1.hasNext()) {
			Map.Entry entry1 = (Map.Entry) it1.next();
			Object key = entry1.getKey();
			Object value = entry1.getValue();
			System.out.println("IdHouse=" + key + " Maxvalue=" + value);
		}
		
		Map<Integer, Double> tmp2=laun.getHouseHoldLeastConsume("1998/01/30", "1999/01/03");
		Iterator it2 = tmp2.entrySet().iterator();
		while (it2.hasNext()) {
			Map.Entry entry2 = (Map.Entry) it2.next();
			Object key = entry2.getKey();
			Object value = entry2.getValue();
			System.out.println("IdHouse=" + key + " Minvalue=" + value);
		}
		
		
		Map<Appliance, Double> tmp3=laun.getTotalConsumeEachAppliance("1998/01/30", "1999/01/03");
		Iterator it3 = tmp3.entrySet().iterator();
		while (it3.hasNext()) {
			Map.Entry entry3 = (Map.Entry) it3.next();
			Appliance key = (Appliance) entry3.getKey();
			Object value = entry3.getValue();
			System.out.println("IdApp=" + key.getIdAppliance() +"name : "+ key.getApplianceName() + "appUnit : "+key.getApplianceUnit() + " Value=" + value);
		}
		
		
		Map<Appliance, Double> tmp4=laun.getApplianceMostConsume("1998/01/30", "1999/01/03");
		Iterator it4 = tmp4.entrySet().iterator();
		while (it4.hasNext()) {
			Map.Entry entry4 = (Map.Entry) it4.next();
			Appliance key = (Appliance) entry4.getKey();
			Object value = entry4.getValue();
			System.out.println("IdApp=" + key.getIdAppliance() +"name : "+ key.getApplianceName() + "appUnit : "+key.getApplianceUnit() + " MaxValue=" + value);
		}
		
		Map<Appliance, Double> tmp5=laun.getApplianceLeastConsume("1998/01/30", "1999/01/03");
		Iterator it5 = tmp5.entrySet().iterator();
		while (it5.hasNext()) {
			Map.Entry entry5 = (Map.Entry) it5.next();
			Appliance key = (Appliance) entry5.getKey();
			Object value = entry5.getValue();
			System.out.println("IdApp=" + key.getIdAppliance() +"name : "+ key.getApplianceName() + "appUnit : "+key.getApplianceUnit() + " MinValue=" + value);
		}
		
		/*Map<String, Double> tmp6=laun.getMostConsumeDate();
		Iterator it6 = tmp6.entrySet().iterator();
		while (it6.hasNext()) {
			Map.Entry entry6 = (Map.Entry) it6.next();
			Object key = entry6.getKey();
			Object value = entry6.getValue();
			System.out.println("Date : " +key + " MaxValue=" + value);
		}
		
		Map<String, Double> tmp7=laun.getLeastConsumeDate();
		Iterator it7 = tmp7.entrySet().iterator();
		while (it7.hasNext()) {
			Map.Entry entry7 = (Map.Entry) it7.next();
			Object key = entry7.getKey();
			Object value = entry7.getValue();
			System.out.println("Date : " +key + " MinValue=" + value);
		}
		
		
		Map<Sensor, Double> tmp8=laun.getSensorsList(2000912);
		Iterator it8 = tmp8.entrySet().iterator();
		while (it8.hasNext()) {
			Map.Entry entry8 = (Map.Entry) it8.next();
			Sensor key = (Sensor) entry8.getKey();
			Object value = entry8.getValue();
			System.out.println("id : " +key.getIdentifySensor() + "sencod : "+ key.getIdentifySensorSecond() + "description: "+key.getDescriptionSensor() + " Value=" + value);
		}
		
		Appliance a = Factory.createAppliance("");
		a.setIdAppliance(15);
		
		int nb = laun.getNumberOfSensor(a);
		System.out.println("Nombre de sensors : " + nb );*/
		
		
	}

}
