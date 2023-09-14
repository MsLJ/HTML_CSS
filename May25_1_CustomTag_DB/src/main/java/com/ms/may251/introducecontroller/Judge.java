package com.ms.may251.introducecontroller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class Judge {
	
	public static void judgenum(HttpServletRequest request){
		int num=Integer.parseInt(request.getParameter("num"));
		ArrayList<Human>hum=new ArrayList<>();
		hum.add(new Human("이",23));
		hum.add(new Human("김",27));
		hum.add(new Human("박",29));
		hum.add(new Human("서",21));
		hum.add(new Human("강",12));
		hum.add(new Human("준",14));
		hum.add(new Human("유",19));
		hum.add(new Human("류",32));
		request.setAttribute("hum", hum);
		request.setAttribute("num", num);
		if (num%2==0) {
			request.setAttribute("jn", "짝수요~");
			
		}else {
			request.setAttribute("jn", "홀수요~");
		}
		
	}

}
