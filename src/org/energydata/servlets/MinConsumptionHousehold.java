package org.energydata.servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.energydata.beans.Factory;
import org.energydata.beans.HouseHold;
import org.energydata.beans.Sensor;
import org.energydata.services.DataLoader;
import org.energydata.services.DataLoaderFileImpl;
import org.energydata.services.Launcher;
import org.energydata.services.LauncherImpl;

public class MinConsumptionHousehold extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

    	
    	Launcher launch = new LauncherImpl();
    	Map<Integer, Double> minConsumptionHousehold = launch.getHouseHoldLeastConsume();
 

    	request.setAttribute("minConsumptionHousehold", minConsumptionHousehold);
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/minConsumptionHousehold.jsp" ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

    	Launcher launch = new LauncherImpl();
    	
    	String maison = request.getParameter("valeur");
    	int houseHoldId = Integer.parseInt(maison);
    	Map<Integer, Double> minConsumptionHousehold = launch.getHouseHoldLeastConsume();
    	Map<Sensor, Double> listOfSensors = launch.getSensorsList(houseHoldId);
    	
    	request.setAttribute("minConsumptionHousehold", minConsumptionHousehold);
    	request.setAttribute("sensorsList", listOfSensors);
    	
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/minConsumptionHousehold.jsp" ).forward( request, response );
    }

}
