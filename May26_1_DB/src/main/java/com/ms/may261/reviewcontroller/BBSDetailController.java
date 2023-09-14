package com.ms.may261.reviewcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BBSDetailController")
public class BBSDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 상세페이지 데이터 갖고
		if (BBSDAO.getBdao().getDetail(request)) {
			//만약에 게시글이 있으면 상세내용 보는거고
			request.setAttribute("cp", "bbs/detail.jsp");

		} else {
			//없으면 알아서 다시 게시판으로 돌아감
			BBSDAO.getBdao().get(1, request);
			request.setAttribute("cp", "bbs/review.jsp");
		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (BBSDAO.getBdao().modify(request)) {
			BBSDAO.getBdao().getDetail(request);
			request.setAttribute("cp", "bbs/detail.jsp");
			
			
		}else {
			BBSDAO.getBdao().get(1, request);
			request.setAttribute("cp", "bbs/review.jsp");
			
		}
	
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

	}

}
