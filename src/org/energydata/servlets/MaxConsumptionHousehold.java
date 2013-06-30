package org.energydata.servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.energydata.beans.Appliance;
import org.energydata.beans.Factory;
import org.energydata.beans.HouseHold;
import org.energydata.beans.Sensor;
import org.energydata.services.DataLoader;
import org.energydata.services.DataLoaderFileImpl;
import org.energydata.services.Launcher;
import org.energydata.services.LauncherImpl;

public class MaxConsumptionHousehold extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

    	
    	Launcher launch = new LauncherImpl();

    	String startDate = request.getParameter("startDate");
    	String endDate = request.getParameter("endDate");
    	
    	Map<Integer, Double> maxConsumptionHousehold = null;
    	
       	if(startDate != null && endDate != null){
       		maxConsumptionHousehold = launch.getHouseHoldMostConsume(startDate,endDate);
       	}
       	else{
       		maxConsumptionHousehold = launch.getHouseHoldMostConsume();
       	} 
    	
    	request.setAttribute("dateDeb", startDate);
    	request.setAttribute("dateFin", endDate);
    	request.setAttribute("maxConsumptionHousehold", maxConsumptionHousehold);
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/maxConsumptionHousehold.jsp" ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

    	Launcher launch = new LauncherImpl();
    	
    	String startDate = request.getParameter("startDate");
    	String endDate = request.getParameter("endDate");
    	
    	String maison = request.getParameter("valeur");
    	int houseHoldId = Integer.parseInt(maison);

    	Map<Integer, Double> maxConsumptionHousehold = null;
    	Map<Sensor, Double> listOfSensors = null;
    	
    	
    	Map<Appliance, Double> minConsumptionAppliance = null;
       	if(startDate != null && endDate != null){
       		maxConsumptionHousehold = launch.getHouseHoldMostConsume(startDate,endDate);
       		listOfSensors = launch.getSensorsList(houseHoldId);
       	}
       	else{
       		maxConsumptionHousehold = launch.getHouseHoldMostConsume();
       		listOfSensors = launch.getSensorsList(houseHoldId);
       	} 
       	
    	request.setAttribute("dateDeb", startDate);
    	request.setAttribute("dateFin", endDate);
    	request.setAttribute("param", "toto");
    	request.setAttribute("maxConsumptionHousehold", maxConsumptionHousehold);
    	request.setAttribute("sensorsList", listOfSensors);
    	
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/maxConsumptionHousehold.jsp" ).forward( request, response );
    }

}
