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
@WebServlet("/Adult")
public class Adult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//인터넷 주소에 한글-x
	//		ㅋ->%2A
	
	//GET:홍길동->%2A->주소에 실려서 전달
	//POST:홍길동->그냥 내부적으로 전달
	
	//Tomcat이 자동으로 함(iso-8859-1이 기본값)
	//ㅋ-?>%2A->ㅋ
	
	//주소 직접 쳐서
	//<a>눌러서
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		사용자가 euc-kr방식으로 요청(post)
//		request.setCharacterEncoding("euc-kr");
//get은 Tomcat설정을 바꿔서 euc-kr로 하도록(server.xml source에 63번줄)
//URIEncoding="euc-kr"추가
		
		
		
		response.setCharacterEncoding("euc-kr");
		// request.getParameter("param변수명");
		//GET방식 요청 파라메터 ㅋ-euc-kr->%2A-euc-kr->ㅋ
		String uname=request.getParameter("uname");
		int age = Integer.parseInt(request.getParameter("age"));
//		int c=Integer.parseInt("c"); 안에 request.getParameter쓸것

//		http://localhost/May15_1_Servlet/Calculator?colorrr=gray&a=5&b=2
		// 인터넷 주소 체계
		// request parameter
		// 사용자가 서버측에 데이터 보낼때
//											?는 구분자
		// 프로토콜://주소:포트번호/폴더/.../파일명?변수명=값&변수명=값
		// protocol-통신방식(http or https)
		// 포트번호 80이 웹서버 기본이라서 포트번호를 80으로 설정했으면 생략가능
		// 폴더명 ROOT는 생략
		// 파일명 index.html은 생략가능
		PrintWriter pw = response.getWriter();
		pw.print("<html><head><meta charset=\"EUC-KR\">");
		pw.print("<style type=\"text/css\">");
		pw.print("</style>");
		pw.print("</head>");
		pw.print("<body>");
		// 삼항 연산도 가능 String say=(a>=20)?"어서오세요":"나가";
		//pw.printf(<h1>%s</h1>),say);
		if (age >= 20) {
			pw.printf("<h1>%s님어서오세요</h1>",uname);

		} else {
			pw.printf("<h1>%s님은 들어올수없습니다.</h1>",uname);
		}

		pw.print("</body></html>");

	}

	// 클에게 POST방식 요청 받으면(form method="post")
	//GET방식 요청:request parameter가 주소에
	//POST방식 요청:request parameter가 주소에 안보임
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//사용자 euc-kr방식으로 요청
		request.setCharacterEncoding("euc-kr");
		//euc-kr 로 응답
		response.setCharacterEncoding("euc-kr");
		
		// request.getParameter("param변수명");
		int age = Integer.parseInt(request.getParameter("age"));
		String uname=request.getParameter("uname");
//		int c=Integer.parseInt("c"); 안에 request.getParameter쓸것

//		http://localhost/May15_1_Servlet/Calculator?colorrr=gray&a=5&b=2
		// 인터넷 주소 체계
		// request parameter
		// 사용자가 서버측에 데이터 보낼때
//											?는 구분자
		// 프로토콜://주소:포트번호/폴더/.../파일명?변수명=값&변수명=값
		// protocol-통신방식(http or https)
		// 포트번호 80이 웹서버 기본이라서 포트번호를 80으로 설정했으면 생략가능
		// 폴더명 ROOT는 생략
		// 파일명 index.html은 생략가능
		PrintWriter pw = response.getWriter();
		pw.print("<html><head><meta charset=\"EUC-KR\">");
		pw.print("<style type=\"text/css\">");
		pw.print("</style>");
		pw.print("</head>");
		pw.print("<body>");
		// 삼항 연산도 가능 String say=(a>=20)?"어서오세요":"나가";
		//pw.printf(<h1>%s</h1>),say);
		if (age >= 20) {
			pw.printf("<h1>%s님 어서오세요</h1>",uname);

		} else {
			pw.printf("<h1>%s님은 들어올수없습니다.</h1>",uname);
		}

		pw.print("</body></html>");


	}

}
