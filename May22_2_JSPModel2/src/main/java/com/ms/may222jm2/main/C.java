package com.ms.may222jm2.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/C")
public class C extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Controller
	// 상황판단해서 M/V를 소환하는 흐름제어
	// 사이트 전체의 진입점
	// GET/POST구분가능한 Servlet
	// PL급 back-end개발자

	// 주소 직접 타이핑
	// ~~해서,<a>눌러서
	// 이 사이트에 처음 접속할때 post방식 쓰는사람은 없을것
	// get벙삭으로 접속할것(주소 직접 타이핑or<a>눌러서)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//v1 html로 바로 이동돼지만 주소칸에 써있는건 GET방식인데도 불구하고 C.java(보안적으로 좋아보임)
		//RequestDispatcher rd=request.getRequestDispatcher("v1.html");
		//rd.forward(request, response);
		//처음에 실행해서 들어오는건 GET방식
		request.getRequestDispatcher("v1.html").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//이후에 계산버튼 눌러서 보여주는 화면은 POST방식
			//계산이후에 결과 보여주기
		M2.calculate(request);//java내에서 만든 객체 가져오기
		request.getRequestDispatcher("v3.jsp").forward(request, response);
		
		
	}

}
