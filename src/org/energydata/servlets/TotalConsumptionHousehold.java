package org.energydata.servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.energydata.beans.Factory;
import org.energydata.beans.HouseHold;
import org.energydata.services.DataLoader;
import org.energydata.services.DataLoaderFileImpl;

public class TotalConsumptionHousehold extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{


    	String[][] listotalConsumptionHousehold=new String[2][2];
    	listotalConsumptionHousehold[0][0]="2001000";
    	listotalConsumptionHousehold[0][1]="450MW";
    	listotalConsumptionHousehold[1][0]="2001111";
    	listotalConsumptionHousehold[1][1]="900MW";
    	request.setAttribute("listotalConsumptionHousehold", listotalConsumptionHousehold);
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/totalConsumptionHousehold.jsp" ).forward( request, response );
    }

}
