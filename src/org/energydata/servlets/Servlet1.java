package org.energydata.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.energydata.beans.Factory;
import org.energydata.beans.HouseHold;
import org.energydata.services.DataLoader;
import org.energydata.services.DataLoaderFileImpl;

public class Servlet1 extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{


		String dataSource = "C:/Users/RCCM3353/Documents/Documents/Workspace/EnergyDataWeb/Data/RawData/1000080-2000903-3009929.txt";
		File f = new File(dataSource);
		DataLoader dataLoader = new DataLoaderFileImpl(f);
		dataLoader.convertMeasureToDailyAverage();   	
    	request.setAttribute("listMeasures", dataLoader.getMeasures());
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/test.jsp" ).forward( request, response );
    }

}
