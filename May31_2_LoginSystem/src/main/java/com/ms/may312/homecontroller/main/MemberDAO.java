package com.ms.may312.homecontroller.main;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberDAO {
	public static boolean isLogined(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("m");
		return m !=null;
	}

	public static void login(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("euc-kr");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			if (id.equals("test") && pw.equals("1234")) {
				Member m = new Member(id, pw);
				request.getSession().setAttribute("m", m);
				request.getSession().setMaxInactiveInterval(10);
				Cookie c=new Cookie("lastLoginedID", id);
				c.setMaxAge(1*60*60*24);
				response.addCookie(c);
				// 로그인 정보가 사이트 어디서든 사용 가능해야
				// 20분뒤 자동으로 없어져야
				// 로그인 정보 자체가 다양...
				// request param-front쪽-x
				// request attr-새로운 요청에서 값 못쓰게 되는-x
				// ses attr
				// cookie-String만 되고,보안적으로는 문제...
				System.out.println("성공");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
