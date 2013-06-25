package org.energydata.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.energydata.beans.Appliance;
import org.energydata.beans.Factory;
import org.energydata.beans.HouseHold;
import org.energydata.services.DataLoader;
import org.energydata.services.DataLoaderFileImpl;
import org.energydata.services.Launcher;
import org.energydata.services.LauncherImpl;

public class Accueil extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    	
    	Launcher launch = new LauncherImpl();

    	Map<Integer, Double> maxConsumptionHousehold = launch.getHouseHoldMostConsume();
    	Map<Integer,Double> minHousehold = launch.getHouseHoldLeastConsume();
    	
    	Map<Appliance, Double> maxAppliance = launch.getApplianceMostConsume();
    	Map<Appliance, Double> minAppliance = launch.getApplianceLeastConsume();
    	
    	Map<String, Double> maxDate = launch.getMostConsumeDate();
    	Map<String, Double> minDate = launch.getLeastConsumeDate();
    	
    	System.out.println(minHousehold.size());
    	request.setAttribute("householdMax", maxConsumptionHousehold);    	
    	request.setAttribute("applianceMax", maxAppliance);
    	request.setAttribute("dateMax", maxDate);
    	request.setAttribute("householdMin", minHousehold);
    	request.setAttribute("applianceMin", minAppliance);
    	request.setAttribute("dateMin", minDate);
    	this.getServletContext().getRequestDispatcher( "/accueil.jsp" ).forward( request, response );
    }

}

