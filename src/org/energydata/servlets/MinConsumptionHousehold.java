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
import org.energydata.services.DataLoader;
import org.energydata.services.DataLoaderFileImpl;
import org.energydata.services.Launcher;
import org.energydata.services.LauncherImpl;

public class MinConsumptionHousehold extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{


    	
//    	String[] household=new String[5];
//    	household[0]="2001064";
//    	household[1]="45MW";
//    	household[2]="8";
//    	household[3]="01-01-1998";
//    	household[4]="02-02-1999";
    	
    	Launcher launch = new LauncherImpl();
    	Map<Integer, Double> minConsumptionHousehold = launch.getHouseHoldLeastConsume();
 

    	request.setAttribute("minConsumptionHousehold", minConsumptionHousehold);
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/minConsumptionHousehold.jsp" ).forward( request, response );
    }

}
