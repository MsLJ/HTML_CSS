package com.ms.may123s_main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//개발자 pc에서 작업 끝났으면 ROOT.war로 export를 가지고 서버자리
//실제 AWS
// C:\progra..\apa\tomcat...
//ROOT폴더 자체를 삭제
//가져온 .war를 거기가다 놓으면 자동으로 압축풀림

//시작-configure tomcat가서  Start
//사용자PC
//	서버주소/,,/ThirdServlet
//대면:서버,PC따로
//비대면/선생님:서버겸PC
//Apachetomcat끄고

/**
 * Servlet implementation class MyFirstServlet
 */

//인터넷->HTTP통신:클라이언트가 요청하면 서버가 응답

@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 클에게 GET방식 요청 받으면
	// 직접 주소쳐서
	// <a href=" "> 눌러서
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("euc-kr");

		// 서버-클라이언트를 연결하는 통신라인
		// 에 붙어있는 응답용 빨대
		PrintWriter pw = response.getWriter();
		pw.print("<html><head><meta charset=\"EUC-KR\">");
		pw.print("<style type=\"text/css\">");
		pw.print("table{float:left; }");
		pw.print("</style>");
		pw.print("</head>");
		pw.print("<body>");

		for (int dan = 2; dan < 11; dan++) {
			pw.print("<table border=\"1\">");
			pw.printf("<tr><th>%d단</th> </tr>", dan);

			for (int i = 1; i < 10; i++) {
				pw.printf("<tr><td>%dx%d=%d</td></tr>", dan, i, dan * i);

			}
			pw.print("</table>");
		}

		pw.print("</body></html>");
	}

	// 클에게 POST방식 요청 받으면
	// 특수한 방법으로만
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("POST방식 요청 받음");

	}

}
