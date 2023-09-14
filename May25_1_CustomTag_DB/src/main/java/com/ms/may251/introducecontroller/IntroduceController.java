package com.ms.may251.introducecontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/IntroduceController")
public class IntroduceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cp", "introduce.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Judge.judgenum(request);
		request.setAttribute("cp", "introduceoutput.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

	}

}
