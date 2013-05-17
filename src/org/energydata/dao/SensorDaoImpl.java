package org.energydata.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.energydata.beans.Sensor;

public class SensorDaoImpl implements SensorDao {
	
	private DAOFactory daoFactory;
	
	SensorDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void create(Sensor sensor) {
		System.out.println("Sensor DAO: ");
		System.out.println(sensor.toString());
		try {
			PreparedStatement preparedStatement = daoFactory.getConnection().prepareStatement("INSERT INTO  Sensor (descriptionSensor,location,idHouseHold,idAppliance) VALUES (?,?,?,?)");
			
			preparedStatement.setString(1, sensor.getDescriptionSensor());
			
			preparedStatement.setString(2, sensor.getLocation());
			
			preparedStatement.setInt(3, sensor.getHouseHold().getIdHouseHold());
			
			preparedStatement.setInt(4, sensor.getAppliance().getIdAppliance());
			

			
			int status = preparedStatement.executeUpdate();
		
			System.out.println("Resultat de l'insertion DAO Appliance: "+status);
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
