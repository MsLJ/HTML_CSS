package com.ms.web2.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ms.web2.main.DateManager;

@WebServlet("/JoinController")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DateManager.getCurYear(request);
		MemberDAO.getMdao().login(request);
		MemberDAO.getMdao().isLogined(request);
//		request.setAttribute("loginpage", "member/login.jsp");
		request.setAttribute("cp", "member/join.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}
	//가입성공:홈
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO.getMdao().join(request);
		MemberDAO.getMdao().login(request);
		MemberDAO.getMdao().isLogined(request);
//		request.setAttribute("loginpage", "member/login.jsp");
		request.setAttribute("cp", "home.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

	}

}
