package org.energydata.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.energydata.beans.HouseHold;

public class HouseHoldDaoImpl implements HouseHoldDao {
	
	private DAOFactory daoFactory;
	
	HouseHoldDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public HouseHold create(HouseHold household) {
		System.out.println("HouseHold DAO: ");
		System.out.println(household.toString());
		System.out.println("id household dao: "+household.getIdHouseHold());
		int id = household.getIdHouseHold();
		HouseHold tmp =this.find(household);

		if(tmp==null){
			try {			
				PreparedStatement preparedStatement = daoFactory.getConnection().prepareStatement("INSERT INTO HouseHold (idHouseHold) VALUES (?)");
				preparedStatement.setInt(1, household.getIdHouseHold());
				int status = preparedStatement.executeUpdate();

				System.out.println("Resultat de l'insertion DAO HouseHold: "+status);
				return household;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

		}
		else{
			return tmp;
		}
	}

	@Override
	public HouseHold find(HouseHold household) {
		try {
			PreparedStatement preparedStatement = daoFactory.getConnection().prepareStatement("SELECT idHouseHold  FROM HouseHold WHERE idHouseHold = ? ");
			
			preparedStatement.setInt(1, household.getIdHouseHold());

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				return household;
				 
			}
			else
			{
			    return null;				
			}	
		
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
