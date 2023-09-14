package com.ms.may242.calc;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	
	public static void Calculate(HttpServletRequest request) {
		
		int x=Integer.parseInt(request.getParameter("x"));
		int y=Integer.parseInt(request.getParameter("y"));
		int hab=x+y;
		int minus=x-y;
		int mok=x/y;
		int gob=x*y;
		
		request.setAttribute("hab", hab);
		request.setAttribute("minus", minus);
		request.setAttribute("mok", mok);
		request.setAttribute("gob", gob);
		
		
	}

}
