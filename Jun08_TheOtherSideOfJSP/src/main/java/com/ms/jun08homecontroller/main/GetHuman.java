package com.ms.jun08homecontroller.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetHuman")
public class GetHuman extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("application/json"); // JSON 형식으로 응답한다는 MIME 타입을 설정합니다.
	    PrintWriter pw = response.getWriter();
	    String humanData = HumanDAO.getHumandao().getHuman(request);
	    pw.print(humanData);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	}

}
