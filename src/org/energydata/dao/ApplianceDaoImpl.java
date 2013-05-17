package org.energydata.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.energydata.beans.Appliance;

public class ApplianceDaoImpl implements ApplianceDao {
	
	private DAOFactory daoFactory;
	
	ApplianceDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public Appliance create(Appliance appliance) {
		System.out.println("Appliance DAO: ");
		System.out.println(appliance.toString());
		Appliance tmp = this.find(appliance);
		
		if(tmp!=null && tmp.getIdAppliance()!=-1){
			
			return tmp;
		}
		else
		{	
		try {
			PreparedStatement preparedStatement = daoFactory.getConnection().prepareStatement("INSERT INTO  Appliance ( applianceName,applianceUnit) VALUES (?,?)");
			
			preparedStatement.setString(1, appliance.getApplianceName());
			
			preparedStatement.setString(2, appliance.getApplianceUnit());

			
			int status = preparedStatement.executeUpdate();
			if(status==1){
					preparedStatement = daoFactory.getConnection()
							.prepareStatement(
									"SELECT max(idAppliance) from Appliance");

					ResultSet rs = preparedStatement.executeQuery();
					rs.next();

					// ResultSet rs = preparedStatement.getGeneratedKeys();
					appliance.setIdAppliance(rs.getInt(1));
			}
			else
			{
				appliance.setIdAppliance(-1);				
			}

			System.out.println("Resultat de l'insertion DAO Appliance: "+status);
			return appliance;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		}
	}

	@Override
	public Appliance find(Appliance appliance) {
		
		try {
			PreparedStatement preparedStatement = daoFactory.getConnection().prepareStatement("SELECT idAppliance, applianceName , applianceUnit FROM Appliance WHERE applianceName = ? AND applianceUnit= ? ");
			
	
			preparedStatement.setString(1, appliance.getApplianceName());
			
			preparedStatement.setString(2, appliance.getApplianceUnit());

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				
				int idAppliance = rs.getInt("idAppliance");
				appliance.setIdAppliance(idAppliance);
				               
				 
			}
			else
			{
				appliance.setIdAppliance(-1);
				
			}	
			
			System.out.println("Resultat de la selection DAO Appliance: "+ appliance.toString());
			return appliance;  
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
			
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
