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
    	Map<Integer, Double> maxConsumptionHousehold = launch.getHouseHoldMostConsume();
    	String startDate = request.getParameter("startDate");
    	String endDate = request.getParameter("endDate");
    	
    	request.setAttribute("startDate", startDate);
    	request.setAttribute("endDate", endDate);
    	request.setAttribute("maxConsumptionHousehold", maxConsumptionHousehold);
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/maxConsumptionHousehold.jsp" ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

    	Launcher launch = new LauncherImpl();
    	
    	String maison = request.getParameter("valeur");
    	int houseHoldId = Integer.parseInt(maison);
    	Map<Integer, Double> maxConsumptionHousehold = launch.getHouseHoldMostConsume();
    	Map<Sensor, Double> listOfSensors = launch.getSensorsList(houseHoldId);
    	
    	request.setAttribute("maxConsumptionHousehold", maxConsumptionHousehold);
    	request.setAttribute("sensorsList", listOfSensors);
    	
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/maxConsumptionHousehold.jsp" ).forward( request, response );
    }

}
