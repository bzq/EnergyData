package org.energydata.dao;


import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.energydata.beans.Measure;

public class MeasureDaoImpl implements MeasureDao {
	
	private DAOFactory daoFactory;
	
	MeasureDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void create(Measure measure) {
		System.out.println("Measure DAO: ");
		System.out.println(measure.toString());
		try {
			PreparedStatement preparedStatement = daoFactory.getConnection().prepareStatement("INSERT INTO  Measure ( idSensor,dateMeasure,state,energyValue) VALUES (?,?,?,?)");
			
			preparedStatement.setInt(1, measure.getSensor().getIdentifySensor());
			
			java.sql.Date sqlDate = new java.sql.Date(measure.getDate().getTime());
			preparedStatement.setDate(2, sqlDate);
			
			preparedStatement.setInt(3, measure.getState());
			
			preparedStatement.setFloat(4, measure.getEnergyValue());
			
			int status = preparedStatement.executeUpdate();
			System.out.println("Resultat de l'insertion DAO Measure: "+status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
