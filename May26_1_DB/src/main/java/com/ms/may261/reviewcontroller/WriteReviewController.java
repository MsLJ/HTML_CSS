package com.ms.may261.reviewcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/WriteReviewController")
public class WriteReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cp", "bbs/write.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BBSDAO.getBdao().write(request);
		BBSDAO.getBdao().get(1,request);
		request.setAttribute("cp", "bbs/review.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
