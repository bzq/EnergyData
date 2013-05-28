package org.energydata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.energydata.beans.Sensor;
import static org.energydata.dao.DAOUtilities.*;

public class SensorDaoImpl implements SensorDao {
	
	private DAOFactory daoFactory;
	
	SensorDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void create(Sensor sensor) {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			connect = daoFactory.getConnection();
			preparedStatement = connect.prepareStatement("INSERT INTO  Sensor (descriptionSensor,location,idHouseHold,idAppliance, idSensor) VALUES (?,?,?,?,?)");
			
			
			preparedStatement.setString(1, sensor.getDescriptionSensor());
			
			preparedStatement.setString(2, sensor.getLocation());
			
			preparedStatement.setInt(3, sensor.getHouseHold().getIdHouseHold());
			
			preparedStatement.setInt(4, sensor.getAppliance().getIdAppliance());
			
			preparedStatement.setInt(5, sensor.getIdentifySensor());
			
			int status = preparedStatement.executeUpdate();
			if(status==1){
			    connect.commit();
				preparedStatement = daoFactory.getConnection()
						.prepareStatement(
								"SELECT max(idSensor) from Sensor");

				rs = preparedStatement.executeQuery();
				rs.next();

				// ResultSet rs = preparedStatement.getGeneratedKeys();
				sensor.setIdentifySensor(rs.getInt(1));
				connect.commit();
				
		}
		else
		{
			sensor.setIdentifySensor(-1);
							
		}
			
			preparedStatement.close();
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
