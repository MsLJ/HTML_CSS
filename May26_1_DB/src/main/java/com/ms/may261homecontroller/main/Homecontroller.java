package com.ms.may261homecontroller.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ms.may261.dataroom.DataDao;
import com.ms.may261.reviewcontroller.BBSDAO;

//톰캣키면->C들 만들어서 ->이벤트 루프->....
@WebServlet("/Homecontroller")
public class Homecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//사실상 톰캣 켰을때랑 같음
	public Homecontroller() {
		BBSDAO.getBdao().setAllMsgCount();
		DataDao.getDto().setAllFileCount();
	
	}
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cp","home.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
