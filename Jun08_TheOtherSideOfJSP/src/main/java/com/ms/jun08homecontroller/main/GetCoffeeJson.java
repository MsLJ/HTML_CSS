package com.ms.jun08homecontroller.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCoffeeJson")
public class GetCoffeeJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Content-Type", "application/json; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw=response.getWriter();
	String coffeeData=CoffeeDAO.getCoffeedao().getCoffee3(request);
	pw.print(coffeeData);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
