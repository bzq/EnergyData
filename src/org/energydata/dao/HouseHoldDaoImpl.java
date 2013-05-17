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
		
		HouseHold tmp =this.find(household);
		
		if(tmp!=null && tmp.getIdHouseHold()!= -1){
			
			return tmp;
		}
		else
		{
		try {
			
			/*
	
			    OraclePreparedStatement pstmt =(OraclePreparedStatement)conn.prepareStatement(vsql);  
			    pstmt.registerReturnParameter(1, Types.BIGINT);  
			    pstmt.executeUpdate();  
			    ResultSet rs=pstmt.getReturnResultSet();  
			    rs.next();  
			    int id=rs.getInt(1);  
			    rs.close();  
			    pstmt.close();  
			    System.out.print("id:"+id);  
			    return id;  
				*/
			
			PreparedStatement preparedStatement = daoFactory.getConnection().prepareStatement("INSERT INTO HouseHold (houseHoldName) VALUES (?)");
			
			preparedStatement.setString(1, household.getHouseName());
			
			
			int status = preparedStatement.executeUpdate();
			if(status==1){
				preparedStatement = daoFactory.getConnection().prepareStatement("SELECT max(idHouseHold) from HouseHold");
				
				ResultSet rs =preparedStatement.executeQuery();
				rs.next();
						
				//ResultSet rs = preparedStatement.getGeneratedKeys();
				household.setIdHouseHold(rs.getInt(1)); 

				}
				else
				{
					household.setIdHouseHold(-1);
									
				}

			
			//int status = preparedStatement.executeUpdate();

			//ResultSet rs = preparedStatement.getGeneratedKeys();
			//household.setIdHouseHold(rs.getInt(1)); 
			System.out.println("Resultat de l'insertion DAO HouseHold: "+status);
			return household;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		}
		
		
	
		
	}

	@Override
	public HouseHold find(HouseHold household) {
		try {
			PreparedStatement preparedStatement = daoFactory.getConnection().prepareStatement("SELECT idHouseHold, houseHoldName  FROM HouseHold WHERE houseHoldName = ? ");
			

	
			preparedStatement.setString(1, household.getHouseName());
			


			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				
				int idHouseHold = rs.getInt("idHouseHold");
				household.setIdHouseHold(idHouseHold);     
				 
			}
			else
			{
			    household.setIdHouseHold(-1);				
			}	
			
			System.out.println("Resultat de la selection DAO HouseHold: "+ household.toString());
			return household;  
		
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
