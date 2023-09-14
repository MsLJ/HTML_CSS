package com.ms.may261.dataroom;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DatadetailController")
public class DatadetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		if (DataDao.getDto().getdetail(no, request)) {
			request.setAttribute("cp", "dt/detail.jsp");
		} else {
			DataDao.getDto().get(1, request);
			request.setAttribute("cp", "dt/data.jsp");
		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (DataDao.getDto().update(request)) {
			request.setAttribute("cp", "dt/detail.jsp");

		} else {
			DataDao.getDto().get(1, request);
			request.setAttribute("cp", "dt/data.jsp");
		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
