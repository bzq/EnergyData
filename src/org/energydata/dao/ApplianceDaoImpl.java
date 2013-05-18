package org.energydata.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static org.energydata.dao.DAOUtilities.*;

import org.energydata.beans.Appliance;
import org.energydata.beans.Factory;

public class ApplianceDaoImpl implements ApplianceDao {
	
	private DAOFactory daoFactory;
	
	ApplianceDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public Appliance create(Appliance appliance) {
		Appliance tmp = this.find(appliance);
		
		if(tmp!=null && tmp.getIdAppliance()!=-1){
			
			return tmp;
		}
		else
		{	
			Connection connect = null;
			PreparedStatement preparedStatement = null;
			ResultSet rs = null;
			
		try {
			connect = daoFactory.getConnection();
			preparedStatement = connect.prepareStatement("INSERT INTO  Appliance ( applianceName,applianceUnit) VALUES (?,?)");
			
			preparedStatement.setString(1, appliance.getApplianceName());
			
			preparedStatement.setString(2, appliance.getApplianceUnit());

			
			int status = preparedStatement.executeUpdate();
			if(status==1){
					preparedStatement = daoFactory.getConnection()
							.prepareStatement(
									"SELECT max(idAppliance) from Appliance");

					rs = preparedStatement.executeQuery();
					rs.next();

					// ResultSet rs = preparedStatement.getGeneratedKeys();
					appliance.setIdAppliance(rs.getInt(1));
			}
			else
			{
				appliance.setIdAppliance(-1);				
			}
			
			System.out.println("Resultat de l'insertion DAO Appliance: "+status);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			fermeturesSilencieuses(rs,preparedStatement);
		}
		return appliance;
		}
	}

	@Override
	public Appliance find(Appliance appliance) {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Appliance newAppliance = null;
		
		try {
			connect = daoFactory.getConnection();
			preparedStatement = connect.prepareStatement("SELECT idAppliance, applianceName , applianceUnit FROM Appliance WHERE applianceName = ? AND applianceUnit= ? ");
			
	
			preparedStatement.setString(1, appliance.getApplianceName());
			
			preparedStatement.setString(2, appliance.getApplianceUnit());

			// execute select SQL stetement
			rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				
				newAppliance = appliance;
				int idAppliance = rs.getInt("idAppliance");
				newAppliance.setIdAppliance(idAppliance);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			fermeturesSilencieuses(rs,preparedStatement);
		}
		return newAppliance; 
	
			
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
