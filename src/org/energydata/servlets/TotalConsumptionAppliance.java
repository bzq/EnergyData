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
import org.energydata.services.DataLoader;
import org.energydata.services.DataLoaderFileImpl;
import org.energydata.services.Launcher;
import org.energydata.services.LauncherImpl;

public class TotalConsumptionAppliance extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{


//    	String[][] listotalConsumptionAppliance=new String[2][2];
//    	listotalConsumptionAppliance[0][0]="Lampe électrique";
//    	listotalConsumptionAppliance[0][1]="450MW";
//    	listotalConsumptionAppliance[1][0]="Frigo";
//    	listotalConsumptionAppliance[1][1]="900MW";
    	Launcher launch = new LauncherImpl();
    	Map<Appliance, Double> listotalConsumptionAppliance = launch.getTotalConsumeEachAppliance();
    	request.setAttribute("listotalConsumptionAppliance", listotalConsumptionAppliance);
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/totalConsumptionAppliance.jsp" ).forward( request, response );
    }

}
