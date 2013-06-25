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

import org.energydata.beans.Appliance;
import org.energydata.beans.Factory;
import org.energydata.beans.HouseHold;
import org.energydata.services.DataLoader;
import org.energydata.services.DataLoaderFileImpl;
import org.energydata.services.Launcher;
import org.energydata.services.LauncherImpl;

public class MaxConsumptionAppliance extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{


//    	String[] appliance=new String[5];
//    	appliance[0]="Chauffage électrique";
//    	appliance[1]="450MW";
//    	appliance[2]="4000";
//    	appliance[3]="01-01-1998";
//    	appliance[4]="02-02-1999";
    	
    	String startDate = request.getParameter("startDate");
    	String endDate = request.getParameter("endDate");
    	
       	Launcher launch = new LauncherImpl();
    	Map<Appliance, Double> maxConsumptionAppliance = launch.getApplianceMostConsume();
    	Appliance appliance = maxConsumptionAppliance.entrySet().iterator().next().getKey();
    	int sensorNumber = launch.getNumberOfSensor(appliance);

    	request.setAttribute("maxConsumptionAppliance", maxConsumptionAppliance);
    	request.setAttribute("sensorNumber", sensorNumber);
    	request.setAttribute("startDate", startDate);
    	request.setAttribute("endDate", endDate);
    	
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/maxConsumptionAppliance.jsp" ).forward( request, response );
    }

}
