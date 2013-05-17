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
			PreparedStatement preparedStatement = daoFactory.getConnection().prepareStatement("INSERT INTO  Measure ( idSensor, idHouseHold ,dateMeasure,state,energyValue) VALUES (?,?,TO_DATE(?,'DD-MM-YYYY HH24:MI'),?,?)");
			
			preparedStatement.setInt(1, measure.getSensor().getIdentifySensor());
			
			preparedStatement.setInt(2, measure.getSensor().getHouseHold().getIdHouseHold());
			
			String date = measure.getDate().getDay()+"-"+(measure.getDate().getMonth()+1)+"-"+measure.getDate().getYear()+" "+measure.getDate().getHours()+":"+measure.getDate().getMinutes();
			System.out.println("date: "+date);
			preparedStatement.setString(3, date);
			
			preparedStatement.setInt(4, measure.getState());
			
			preparedStatement.setFloat(5, measure.getEnergyValue());
			
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
