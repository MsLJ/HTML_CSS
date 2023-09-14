package com.ms.mat223unc.main;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	
	public static void calculate(HttpServletRequest request) {
		double value=Double.parseDouble(request.getParameter("value"));
		String area=request.getParameter("area");
		double inch=value*2.54;
		double peng=value*3.3058;
		double ff=(value*9/5)+32;
		double mih=value/1.609;
		double result=0;
		if (area.equals("cm")) {
			result=inch;
			
		}else if(area.equals("m2")) {
			result=peng;
		}else if(area.equals("cdu")) {
			result=ff;
			
		}else if (area.equals("kmh")) {
			result=mih;
		}
		
		
		Calculator2 cc=new Calculator2(inch,peng,ff,mih,result,area);
		request.setAttribute("ccc", cc);
		
		
		
		
	}
	
		
	
	

}
