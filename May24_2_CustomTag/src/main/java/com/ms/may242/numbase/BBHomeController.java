package com.ms.may242.numbase;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BBHomeController")
public class BBHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//계속접속할때마다 게임 답이 초기화돼서 새로운 답을 뽑기? 잘못됐다
	//싱글턴이 아닌 다른 방법을 써봐야할것
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NumBaseballgame.getNBG().getgameAns();
		request.setAttribute("cp","calc/inoutput.jsp" );
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NumBaseballgame.getNBG().judge(request);
		request.setAttribute("cp","calc/inoutput.jsp" );
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		
		
	}

}
