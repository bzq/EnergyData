package org.energydata.services;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.energydata.beans.HouseHold;
import org.energydata.beans.Measure;
import org.energydata.dao.DAOFactory;


public class LauncherImpl implements Launcher {
	
	private DAOFactory daoFactory;
    
	
	
	


	@Override
	public HouseHold getMostConsumerHousehold() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public Map getTotalHouseHold(Date start, Date fin){
		
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		
		Map<String,double> tmp = new Map<String,double>();
		
		try {
			connect = daoFactory.getConnection();
			preparedStatement = connect.prepareStatement("SELECT h.idhousehold,sum(m.energyvalue) as Total FROM household h,appliance a, sensor s, measure m WHERE h.idhousehold=s.idhousehold and a.idappliance=s.idappliance and s.idsensor = m.idsensor where m.dateMeasure between(?,?) group by h.idhousehold");

				Timestamp ts1 = new  Timestamp(start.getTime());
				Timestamp ts2 = new  Timestamp(fin.getTime());
				
				preparedStatement.setTimestamp(1, ts1);
				preparedStatement.setTimestamp(2, ts2);
				
				ResultSet  rs =preparedStatement.executeQuery();
				
				
				while(rs.next()){
					
					String idHouseHold = rs.getString(0);
					Double  total = rs.getDouble(1);
				}
					
				
				
				
				
		 //	    preparedStatement.addBatch();
		   // 	preparedStatement.executeUpdate();
		  //   	preparedStatement.close();
		  	
	     	//	connect.commit();
				
			
		
		
	}
	catch(Exception e){
		
	System.out.println(e.getMessage());
	
	}
		return 0;
		
		
	}
	
	
    
	

}
