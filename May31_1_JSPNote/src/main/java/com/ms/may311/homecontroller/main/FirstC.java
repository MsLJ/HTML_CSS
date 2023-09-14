package com.ms.may311.homecontroller.main;

//C를 왜SerVlet=
//	JSP도 가능한데 왜?
//	요청방식은 2가지인데
//	JSP는 get/post구분못하고
//	자바소스 자동완성 별로
//	V쪽에 특화
//	결론:가능하지만 굳이SerVlet이 있는데 불편하기에 사용하지않음
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstC") // SerVlet 톰캣에 등록
public class FirstC extends HttpServlet {
	// 별로 필요없는데 지우면 노란줄뜸
	private static final long serialVersionUID = 1L;

	// 톰캣이 켜지면->등록된 서블릿을 자동으로 만드니
	public FirstC() {

	}

	// 클라이언트로 부터 Get방식 받으면
	// 주소직접 타이핑
	// <a>
	// JavaScript의location.href
	// <form>+<button>
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) {
			request.getRequestDispatcher("jsp/firstV.jsp").forward(request, response);
			
		}
		//어떤 사이트에 처음 들어갈때

	}

	// 클라이언트로 부터 Post방식 받으면
	// <form>+<button>
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
