package org.energydata.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.energydata.beans.Measure;
import org.energydata.beans.Sensor;
import org.joda.time.DateTime;

import static org.energydata.dao.DAOUtilities.*;

public class MeasureDaoImpl implements MeasureDao {
	
	private DAOFactory daoFactory;
	
	MeasureDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void create(Measure measure) {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		try {
			connect = daoFactory.getConnection();
			preparedStatement = connect.prepareStatement("INSERT INTO  Measure ( idSensor, idHouseHold ,dateMeasure,state,energyValue) VALUES (?,?,TO_DATE(?,'DD-MM-YYYY HH24:MI'),?,?)");
			
			preparedStatement.setInt(1, measure.getSensor().getIdentifySensor());
			
			preparedStatement.setInt(2, measure.getSensor().getHouseHold().getIdHouseHold());
			DateTime dt = new DateTime(measure.getDate());
			String date = dt.getDayOfMonth()+"-"+dt.getMonthOfYear()+"-"+dt.getYear()+" "+dt.getHourOfDay()+":"+dt.getMinuteOfHour();
			preparedStatement.setString(3, date);

			preparedStatement.setInt(4, measure.getState());
			
			preparedStatement.setFloat(5, measure.getEnergyValue());
		
			
			int status = preparedStatement.executeUpdate();
			
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			fermeturesSilencieuses(preparedStatement,connect);
		}
	}
	
	
	public void createList(Sensor sensor,List<Measure> measureList){
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<Measure> measureLocal = new ArrayList<Measure>(measureList);

		try {
			connect = daoFactory.getConnection();
			connect.setAutoCommit(false);
			//preparedStatement = connect.prepareStatement("INSERT INTO  Measure ( idSensor, idHouseHold ,dateMeasure,state,energyValue) VALUES (?,?,to_date(?,'dd-mm-yyyy hh24:mi'),?,?)");
			preparedStatement = connect.prepareStatement("INSERT INTO  Measure ( idSensor, dateMeasure,state,energyValue) VALUES (?,to_date(?,'dd-mm-yyyy hh24:mi'),?,?)");
		//	preparedStatement = connect.prepareStatement("INSERT INTO  Measure ( idSensor, dateMeasure,state,energyValue) VALUES (?,?,?,?)");
			
			
			for(Measure measure : measureLocal){
			//	preparedStatement = connect.prepareStatement("INSERT INTO  Measure ( idSensor, dateMeasure,state,energyValue) VALUES (?,?,?,?)");
				
				System.out.println("Date from list measure : "+measure.getDate());
			//	System.out.println(sensor.getIdentifySensor());
	     		//preparedStatement.setInt(1, measure.getSensor().getIdentifySensor());
				preparedStatement.setInt(1, sensor.getIdentifySensor());
				
				//preparedStatement.setInt(2, measure.getSensor().getHouseHold().getIdHouseHold());
				//preparedStatement.setInt(2, sensor.getHouseHold().getIdHouseHold());
				DateTime dt = new DateTime(measure.getDate());
				String date = dt.getDayOfMonth()+"-"+dt.getMonthOfYear()+"-"+dt.getYear()+" "+dt.getHourOfDay()+":"+dt.getMinuteOfHour();
		    
				System.out.println("Date insert pour dao : "+date);
				preparedStatement.setString(2, date);
			//	Timestamp ts = new Timestamp(measure.getDate().getTime());
			//	preparedStatement.setTimestamp(2, ts);
				
				preparedStatement.setInt(3, measure.getState());
				//System.out.println("date: "+ ts);
				preparedStatement.setFloat(4, measure.getEnergyValue());
		    //  preparedStatement.addBatch();
		    	preparedStatement.executeUpdate();
		    // 	preparedStatement.close();
		  	
	     		connect.commit();
				
			}
			
			//System.out.println(j);
		   // int[] status = preparedStatement.executeBatch();

		    // connect.commit();
			
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());

		}finally{
			fermeturesSilencieuses(preparedStatement,connect);
		}
		
		
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
