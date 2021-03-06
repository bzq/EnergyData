package org.energydata.servlets;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.joda.time.DateTime;

public class MinConsumptionDate extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    	
    	Launcher launch = new LauncherImpl();
    	String startDate = request.getParameter("startDate");
    	String endDate = request.getParameter("endDate");
    	
    	Map<String, Double> minConsumptionDate = null;
    	
       	if(startDate != null && endDate != null){
//       		minConsumptionDate = launch.getMostConsumeDate(startDate,endDate);
       	}
       	else{
       		minConsumptionDate = launch.getMostConsumeDate();
       	} 

    	request.setAttribute("startDate", startDate);
    	request.setAttribute("endDate", endDate);
    	request.setAttribute("minConsumptionDate", minConsumptionDate);
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/minConsumptionDate.jsp" ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

    	Launcher launch = new LauncherImpl();
    	
    	String dat = request.getParameter("valeur");
    	String startDate = request.getParameter("startDate");
    	String endDate = request.getParameter("endDate");
    	
    	Map<String, Double> minConsumptionDate = null;
    	
       	if(startDate != null && endDate != null){
//       		minConsumptionDate = launch.getMostConsumeDate(startDate,endDate);
       	}
       	else{
       		minConsumptionDate = launch.getMostConsumeDate();
       	} 
    	
       	String date = minConsumptionDate.entrySet().iterator().next().getKey();
       	System.out.println(date);
    	Map<Appliance, Double> listOfAppliances = launch.getTotalConsumeEachAppliance(date, date);

    	request.setAttribute("startDate", startDate);
    	request.setAttribute("endDate", endDate);
    	request.setAttribute("minConsumptionDate", minConsumptionDate);
    	request.setAttribute("appliancesList", listOfAppliances);
    	
    	
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/minConsumptionDate.jsp" ).forward( request, response );
    }

}
