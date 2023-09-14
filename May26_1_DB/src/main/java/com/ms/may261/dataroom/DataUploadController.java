package com.ms.may261.dataroom;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/DataUploadController")
public class DataUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("cp", "dt/upload.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (DataDao.getDto().update(request)) {
//			DataDao.getDto().getdetail(request);
			request.setAttribute("cp", "dt/detail.jsp");
		} else {
			DataDao.getDto().get(1, request);
			request.setAttribute("cp", "dt/data.jsp");

		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

	}

}
