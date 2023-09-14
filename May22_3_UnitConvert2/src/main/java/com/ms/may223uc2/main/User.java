package com.ms.may223uc2.main;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class User {
	public static void userinfo(HttpServletRequest request){
		try {
			MultipartRequest mr=new MultipartRequest(request, request.getSession().getServletContext().getRealPath("img")
					,10485760,"euc-kr",new DefaultFileRenamePolicy());
			
			//mr로바꿔야지 준하야 mr로 새로 인코딩 방식을 만들었으면
			String name=mr.getParameter("name");
			double height=Double.parseDouble(mr.getParameter("height"));
			double weight=Double.parseDouble(mr.getParameter("weight"));
			double bmi=weight/(height*height);
			String p=URLEncoder.encode(mr.getFilesystemName("p"),"euc-kr").replace("+"," ");
			String result="저체중";
			if (bmi>=25) {
				result="비만";
				
			}else if(bmi<=24.9&&bmi>23.0) {
				result="과체중";
			}else if(bmi<=23&&bmi>18.5) {
				result="정상";
			}
			User2 u=new User2(name,height,weight,bmi,result,p);
			request.setAttribute("uu",u);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}

}
