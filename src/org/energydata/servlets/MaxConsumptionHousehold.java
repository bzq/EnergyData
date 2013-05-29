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

public class MaxConsumptionHousehold extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{


    	String[] household=new String[5];
    	household[0]="2001000";
    	household[1]="450MW";
    	household[2]="600";
    	household[3]="01-01-1998";
    	household[4]="02-02-1999";

    	request.setAttribute("household", household);
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/maxConsumptionHousehold.jsp" ).forward( request, response );
    }

}
