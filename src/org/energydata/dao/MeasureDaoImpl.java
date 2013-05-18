package org.energydata.dao;


import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.energydata.beans.Measure;
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
			
			String date = measure.getDate().getDay()+"-"+(measure.getDate().getMonth()+1)+"-"+measure.getDate().getYear()+" "+measure.getDate().getHours()+":"+measure.getDate().getMinutes();
			preparedStatement.setString(3, date);
			
			preparedStatement.setInt(4, measure.getState());
			
			preparedStatement.setFloat(5, measure.getEnergyValue());
		
			
			int status = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			fermetureSilencieuse(preparedStatement);
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
