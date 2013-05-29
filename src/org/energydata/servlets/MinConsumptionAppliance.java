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

public class MinConsumptionAppliance extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{


    	String[] appliance=new String[5];
    	appliance[0]="Ampoule électrique (15W)";
    	appliance[1]="10MW";
    	appliance[2]="3000";
    	appliance[3]="01-01-1998";
    	appliance[4]="02-02-1999";

    	request.setAttribute("appliance", appliance);
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/minConsumptionAppliance.jsp" ).forward( request, response );
    }

}
