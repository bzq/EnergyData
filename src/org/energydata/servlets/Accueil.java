package org.energydata.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.energydata.beans.Factory;
import org.energydata.beans.HouseHold;
import org.energydata.services.DataLoader;
import org.energydata.services.DataLoaderFileImpl;
import org.energydata.services.Launcher;
import org.energydata.services.LauncherImpl;

public class Accueil extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    	
//    	Launcher launch = new LauncherImpl();
//    	Map maxHousehold = launch.getHighestConsumptionHousehold();
//    	Map maxAppliance = launch.getHighestConsumptionAppliance();
//    	Map maxDate = launch.getHighestConsumptionDate();
//    	request.setAttribute("household", maxHousehold.get(0));
//    	request.setAttribute("appliance", maxAppliance.get(0));
//    	request.setAttribute("date", maxDate.get(0));
    	this.getServletContext().getRequestDispatcher( "/accueil.jsp" ).forward( request, response );
    }

}

