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

public class FenetreGlissante extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/dateSelectorMeasure.jsp" ).forward( request, response );
    }

}
