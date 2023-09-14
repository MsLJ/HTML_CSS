package com.ms.may311.seceondcontroller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondM {
	public static void test(HttpServletRequest request,HttpServletResponse response) {
		int q = Integer.parseInt(request.getParameter("q"));
		System.out.println(q);

		// request parameter
		// front-end쪽에서 만들어진 값
		// request 소속(GET방식 주소에,POST방식 내부적으로)
		// String or String[]
		// Java에서 :request.getParameter("파라메터변수명")
		// EL로 :${param.파라메터변수명}
		String w = "ㅋ";
		request.setAttribute("w", w);
		// request Attribute
		// back-end쪽에서 만들어진 값
		// request소속
		// Object
		// Java에서:request.getAttribute("어트리뷰트명")
		// EL로:${어트리뷰트명}
		// ${어트리뷰트명.멤버변수명}
		String www = (String) request.getAttribute("w");
		System.out.println(www);

		// session attribute
		// back-end쪽에서 만들어진 값
		// session소속(사용자-서버 연결상태)
		// ->기본 30분(30분동안 요청같은거 하면 갱신)
		// ->연결만 되어있다면 어디서든 사용가능
		// ->사용자 개인의 공간
		// Java에서:request.getSession.getAttribute("어트리뷰트명");
		// EL로 :${sessionScope.어트리뷰트명}
		double f = 123.45;
		HttpSession hs = request.getSession();
		hs.setAttribute("f", f);
		hs.setMaxInactiveInterval(10);// 세션 유지시간 5초동안지정

		// cookie
		// 	back-end쪽에서 만들어진 값
		// 	사용자pc에 파일로 저장
		//	기본 유지시간?
		// ->브라우저를 끄든지,컴퓨터를 재부팅하든지
		//	String
		//	Java에서:...
		//	EL로:${cookie.이름.value}
		
		//쿠키를 만들어 그 안에 값을 저장할때
		String newjeans = "Cookie";
		Cookie c=new Cookie("g", newjeans);
		//쿠키 남아있는시간지정
		c.setMaxAge(10*60);
		response.addCookie(c);
	}

}
