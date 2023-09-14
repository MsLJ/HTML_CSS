package com.ms.may311.thirdcontroller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class ThirdM {
	
	
	public static void test2(HttpServletRequest request) {
		String e=request.getParameter("e");
//		String q=request.getParameter("q");
		System.out.println(e);
		request.setAttribute("e", e);
		
		double fff=(Double)request.getSession().getAttribute("f");
		System.out.println(fff);
		
		//지금 만들어져있는 쿠키들
		//쿠키에 들어있는정보를 빼올때
//		Cookie[] cookies=request.getCookies();
//		for (Cookie c : cookies) {
//			if (c.getName().equals("g")) {
//				System.out.println(c.getValue());
//				
//			}
			
		}
		
	}


