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
			// Get instance of Object Connection
			connect = daoFactory.getConnection();
			// Disable AutoCommit
			connect.setAutoCommit(false);
            //  Prepare the query for insert
			preparedStatement = connect.prepareStatement("INSERT INTO  Measure ( idSensor, dateMeasure,state,energyValue) VALUES (?,?,?,?)");
			
			// Go through the table measure
			for(Measure measure : measureLocal){
				
			//	System.out.println("Date from list measure : "+measure.getDate());
                // Set the ID Sensor for insert
				preparedStatement.setInt(1, sensor.getIdentifySensor());
                // Create a Timestamp instance
				Timestamp ts = new Timestamp(measure.getDate().getTime());
				// Set the date for insert
				preparedStatement.setTimestamp(2, ts);
				// Set the state of this measure for insert
				preparedStatement.setInt(3, measure.getState());
				// Set the value of this measure for insert
				preparedStatement.setFloat(4, measure.getEnergyValue());
				// Use the transaction addBatch for insert
		        preparedStatement.addBatch();
				
			}
			
			// executeBatch 
		    int[] status = preparedStatement.executeBatch();
            // Commit the result
		     connect.commit();
			// Close the connection
			preparedStatement.close();
		} catch (SQLException e) {
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
