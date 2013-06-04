package org.energydata.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Test {
	
	
	
	
	
	public static void main(String args[]){
		
		
		Date t = new Date();
		

		
	
	
		
		String date ="29/03/98";
		String time= "02:00";
		
        
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yy HH:mm");
		DateTime dt = formatter.parseDateTime(date+" "+time);
		
		
		t=dt.toDate();
		
		System.out.println(t);
	//	Date newDate=null;
		//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");  
		
		//  SimpleTimeZone tz = new SimpleTimeZone(0, "Out Timezone");  
		 // dateFormat.setTimeZone(tz);

		//try {  
		 //   newDate = dateFormat.parse();  

	//	} catch (ParseException e) {  
		//    e.printStackTrace();  
	//	}	
		//System.out.println(newDate.toString());
		
		
		
		
		
		
		
		
		
		
	}

}
