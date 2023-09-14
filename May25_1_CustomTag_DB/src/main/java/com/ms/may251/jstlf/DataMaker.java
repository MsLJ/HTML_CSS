package com.ms.may251.jstlf;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DataMaker {

public static void make(HttpServletRequest request) {
	
	int a=244441231;
	request.setAttribute("a", a);
	
	double b=0.121513512;
	request.setAttribute("b", b);
	
	
	Date now=new Date();
	request.setAttribute("now", now);
	
	
	
	
	
	
}
}
