package com.ms.may231el.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Homecontroller")
public class Homecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	//C
	// 첫 접속:get
	// 계산: get
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) {
			request.getRequestDispatcher("input.html").forward(request, response);
			
		}else {
			Birth.age(request);
			request.getRequestDispatcher("output.jsp").forward(request, response);
			
		}	
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
