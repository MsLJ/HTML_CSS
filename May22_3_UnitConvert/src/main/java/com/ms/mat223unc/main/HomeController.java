package com.ms.mat223unc.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//if(!request.getParameterNames().hasMoreElements()) {
			request.getRequestDispatcher("view.html").forward(request, response);
			
		//}//else {
			//request.getRequestDispatcher("view.jsp").forward(request, response);
		//}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calculator.calculate(request);
		request.getRequestDispatcher("view.jsp").forward(request, response);
		
		
		
	}

}
