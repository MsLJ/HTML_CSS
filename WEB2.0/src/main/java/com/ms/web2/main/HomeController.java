package com.ms.web2.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ms.web2.member.MemberDAO;
import com.ms.web2.photozone.PhotoDAO;
import com.ms.web2.sns.SnsDAO;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public HomeController() {
		SnsDAO.getSdo().setAllSNSCount();
		PhotoDAO.getPhotodao().setAllPhotoCount();
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO.getMdao().login(request);
		MemberDAO.getMdao().isLogined(request);
//		request.setAttribute("loginpage", "member/login.jsp");
		request.setAttribute("cp", "home.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
