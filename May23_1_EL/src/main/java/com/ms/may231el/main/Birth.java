package com.ms.may231el.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class Birth {
	public static void age(HttpServletRequest request) {
		String btd = request.getParameter("b");
		int btd2 = Integer.parseInt(request.getParameter("b2"));
		String by = btd.substring(0, 2);// 앞에 2자리만 뽑아내기 (0~2)까지니까
		if (btd2<3) {
			by="19"+by;
			
			
		}else {
			by="20"+by;
		}
		int birthyear=Integer.parseInt(by);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		//년도 4자리만 나이 계산할꺼니까
		String now=sdf.format(new Date());
		// 일단 오늘 날짜중에 년도만String으로 받아오기 
		int curyear=Integer.parseInt(now);
		//숫자로 다시 변형 계산하기위해
		int age=curyear-birthyear+1;
		//나이는 1살더 추가
		request.setAttribute("agee", age);
		
		
		Doge d=new Doge(10000,"일론 머스큰");
		request.setAttribute("ddd", d);
		
		ArrayList<Doge> doges=new ArrayList<>();
		doges.add(new Doge(100,"이ㄹㄴ"));
		doges.add(new Doge(1000,"이런"));
		doges.add(new Doge(10000,"이론"));
		doges.add(new Doge(12000,"이란"));
		request.setAttribute("doges", doges);
		
		
		
		

	}

}
