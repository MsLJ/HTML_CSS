package com.ms.inoutp.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setCharacterEncoding("euc-kr");
		
		// request.getParameter("param변수명");
		
		String id=request.getParameter("id");
		String pww=request.getParameter("pww");
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
		pw.printf("<h1>id:%s</h1>",id);
		

		pw.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("euc-kr");
		//euc-kr 로 응답
		response.setCharacterEncoding("euc-kr");
		
		// request.getParameter("param변수명");
		
		String id=request.getParameter("id");
		String pww=request.getParameter("pww");
		String sex=request.getParameter("sex");
		String area=request.getParameter("area");
		String mit=request.getParameter("introduce");
		mit=mit.replace("\r\n","<br>");
		//Checkbox만
		String[] trans=request.getParameterValues("transportation");
//		int c=Integer.parseInt("c"); 안에 request.getParameter쓸것
		String[]h=request.getParameterValues("hobby");
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
		pw.printf("<h1>id:%s</h1>",id);
		pw.printf("<h1>pw:%s</h1>", pww);
		pw.printf("<h1>성별:%s</h1>", sex);
		pw.printf("<h1>지역:%s</h1>", area);
		//아무것도 선택 안하면 배열의 length가 0이 아니고
		//배열 자체가 null인거
		if (trans!=null) {
			pw.print("<h1>이동수단</h1>");
			for (String s : trans) {
				pw.print(s+"<br>");
				
			}
			
		}
		if (h!=null) {
			pw.print("<h1>취미</h1>");
			
		}
		for (String hs : h) {
			pw.print(hs+"<br>");
			
		}
		pw.printf("<h5>자기소개:%s</h5>",mit);

		pw.print("</body></html>");


	}
	}


