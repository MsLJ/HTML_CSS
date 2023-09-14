package com.ms.may123s_main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@XXX:annotation,XXX에 뭐 들어가냐에 따라 다 다름
//	근데 대부분은 원래 따로 설정해야하는데,
//	annotation쓰면 자동으로 해줌




/**
 * Servlet implementation class MyFirstServlet
 */
//@WebServlet: 
//	원래 서블릿 만들면 따로 Tomcat에 등록해야 사용가능
//	Tomcat5.0부터 추가된 자동등록
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	//MyServlet:HTTPServlet의 기능 다물려받았고 거기다 뭔가 추가
	
	//작업하면서 버전 표시하라고 만들어준거->지워도 됨
	//지우면 warning띄워서
	private static final long serialVersionUID = 1L;
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	//event-driven programming
	//	이벤트 루프 돌다가,어떤 이벤트 발생하면 그거 처리하고 다시 루프로 복귀
	
	//웹서버/WAS: 클라이언트로부터 요청받으면 거기에 대해 응답하는거
	
	//Servlet:WAS에서만 실행가능
	//		main이 Tomcat에 
	//		Tomcat에 내장되어있는 main에서 MyServlet을 자동으로 만들어서
	//		Tomcat종료시킬때까지 무한루프
	
	
	
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  //클라이언트로부터 GET방식 요청받으면
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//클라이언트로부터 POST방식 요청받으면
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
