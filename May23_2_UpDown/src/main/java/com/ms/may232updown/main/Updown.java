package com.ms.may232updown.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class Updown {
	private int gameans; 
	private static final Updown UD=new Updown();
	private int count;
	public Updown() {
		// TODO Auto-generated constructor stub
	}
	public static Updown getUd(){
		return UD;
	}

	public  void pickAns() {
		gameans=new Random().nextInt(10000)+1;
	}
	public  void udg(HttpServletRequest request) {
		count++;
		System.out.println(gameans);
		int answer=Integer.parseInt(request.getParameter("aws"));
		if (answer==gameans) {
			request.setAttribute("result", count+"턴만에 정답");
			pickAns();
		}else if (answer>gameans) {
			request.setAttribute("result","Down");
			
		}else  {
			request.setAttribute("result", "Up");
			
		}
		
		
		
		
		
	}
		
	}
	
		
	


