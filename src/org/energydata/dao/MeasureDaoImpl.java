package org.energydata.dao;


import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.energydata.beans.Measure;
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
