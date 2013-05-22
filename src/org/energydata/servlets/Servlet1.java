package org.energydata.servlets;

import java.io.IOException;
import java.io.PrintWriter;


public class Servlet1 extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/test.jsp" ).forward( request, response );
    }

}
