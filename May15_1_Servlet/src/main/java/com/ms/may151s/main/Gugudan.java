package com.ms.may151s.main;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/Gugudan")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("euc-kr");
		//request.getParameter("param변수명");
		int dan=Integer.parseInt(request.getParameter("dan"));
//		int c=Integer.parseInt("c"); 안에 request.getParameter쓸것
		
//		http://localhost/May15_1_Servlet/Calculator?colorrr=gray&a=5&b=2
		//인터넷 주소 체계		
		//									request parameter
		//										사용자가 서버측에 데이터 보낼때
//											?는 구분자
		//	프로토콜://주소:포트번호/폴더/.../파일명?변수명=값&변수명=값
		//		protocol-통신방식(http or https)
		//		포트번호 80이 웹서버 기본이라서 포트번호를 80으로 설정했으면 생략가능
		//		폴더명 ROOT는 생략
		//		파일명 index.html은 생략가능
		PrintWriter pw=response.getWriter();
		pw.print("<html><head><meta charset=\"EUC-KR\">");
		pw.print("<style type=\"text/css\">");
		pw.print("</style>");
		pw.print("</head>");
		pw.print("<body>");
		
			pw.print("<table border=\"1\">");
			pw.printf("<tr><th>%d단</th> </tr>", dan);

			for (int i = 1; i < 10; i++) {
				pw.printf("<tr><td>%dx%d=%d</td></tr>", dan, i, dan * i);

			}
			pw.print("</table>");
		
		
		
		
		pw.print("</body></html>");
		
	}

	//클에게 POST방식 요청 받으면
	//		특수한 방법으로만
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 System.out.println("POST방식 요청 받음");
	
	}


}
