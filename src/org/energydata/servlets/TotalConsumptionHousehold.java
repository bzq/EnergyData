package org.energydata.servlets;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
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

public class TotalConsumptionHousehold extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{




    	Launcher launch = new LauncherImpl();
    	Map<Integer, Double> listotalConsumptionHousehold = launch.getTotalConsumeEachHouseHold();
//    	listotalConsumptionHousehold.put(2001000,450.0);
//    	listotalConsumptionHousehold.put(2001101,500.0);
    	request.setAttribute("listotalConsumptionHousehold", listotalConsumptionHousehold);
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/totalConsumptionHousehold.jsp" ).forward( request, response );
    }

}

