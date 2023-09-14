package com.ms.may311.thirdcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ms.may311.seceondcontroller.SecondM;

@WebServlet("/ThirdController")
public class ThirdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ThirdM.test2(request);
		request.getRequestDispatcher("jsp/thirdV.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ThirdM.test2(request);
		request.getRequestDispatcher("jsp/thirdV.jsp").forward(request, response);
	}

}
