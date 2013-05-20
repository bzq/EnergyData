package org.energydata.dao;

import java.sql.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.energydata.beans.HouseHold;
import static org.energydata.dao.DAOUtilities.*;


public class HouseHoldDaoImpl implements HouseHoldDao {
	
	private DAOFactory daoFactory;
	
	HouseHoldDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public HouseHold create(HouseHold household) {
		HouseHold tmp =this.find(household);

		if(tmp==null){
			Connection connect = null;
			PreparedStatement preparedStatement = null;
			try {			
				connect = daoFactory.getConnection();
				preparedStatement = connect.prepareStatement("INSERT INTO HouseHold (idHouseHold) VALUES (?)");
				preparedStatement.setInt(1, household.getIdHouseHold());
				int status = preparedStatement.executeUpdate();

				System.out.println("Resultat de l'insertion DAO HouseHold: "+status);
				preparedStatement.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				fermetureSilencieuse(preparedStatement);
			}
			return household;

		}
		else{
			return tmp;
		}
	}

	@Override
	public HouseHold find(HouseHold household) {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		HouseHold newHousehold = null;
		
		try {
			connect =  daoFactory.getConnection();
			preparedStatement = connect.prepareStatement("SELECT idHouseHold  FROM HouseHold WHERE idHouseHold = ? ");		
			preparedStatement.setInt(1, household.getIdHouseHold());
			rs = preparedStatement.executeQuery();	
			if (rs.next()) {
				newHousehold = household;
			}
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			fermeturesSilencieuses(rs,preparedStatement);
		}
		return newHousehold;
	
		
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
