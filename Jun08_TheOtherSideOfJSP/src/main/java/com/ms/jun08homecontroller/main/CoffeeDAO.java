package com.ms.jun08homecontroller.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.management.MBeanServerDelegateMBean;
import javax.servlet.http.HttpServletRequest;

import ms.ljh.db.manager.MsDBManager;

public class CoffeeDAO {
	
	private static final CoffeeDAO COFFEEDAO=new CoffeeDAO();
	
	public CoffeeDAO() {
		// TODO Auto-generated constructor stub
	}
	public static CoffeeDAO getCoffeedao() {
		return COFFEEDAO;
	}

	public void getCoffee(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MsDBManager.connect("msPool");
			String sql = "select*from jun08_coffee";
			pstmt = con.prepareStatement(sql);
			ArrayList<Coffee> coffees = new ArrayList<>();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				coffees.add(new Coffee(rs.getString("coffee_name"), rs.getInt("coffee_price")

				));

			}
			request.setAttribute("coffee", coffees);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		MsDBManager.close(con, pstmt, rs);

	}
	//HTML
	//-------------------디자인
	//HTML+CSS+JavaScript
	//----------------------디자인 이벤트가 부족
	//JSP
	//----------------------
	//JSP Model2
	//----------------------v에 Java가?
	//JSP Model2+EL+JSTL
	//--------------------유지보수
	//Spring:JSP Model 2를 유지보수하기
	//좋게 만드는 방법론 AOP
	//eGoFramework:전자정부프레임워크
	//Spring + Maven +MyBatis
	
	

	// ArrayList<객체>로 만들어서
	// request.getparameter-x request소속
	// request.setAttribute:request 소속
	// session attribute:클-서 연결상태 소속
	// cookie:클 컴퓨터 소속
	
	//제3자(웹 브라우저 아님)에게 데이터 주려면
	//=>글자 한덩어리로 만들어서 응답
	//데이터 주는쪽과 받는쪽과 약속된 형식이 필요할것
	//=>국제표준형식
	//데이터를 HTML모양 빌려서 표현:XML
	//데이터를 javaScript모양 빌려서 표현:JSON
	//제3자의 입장에서
	//문자가 다 깨지고 
	//split 하기 까다롭..
	
	//빅데이터의 결과들은 JSON/XML로 만들어서
	//그 결과를 가져가서 parse
	
	//JSON이 파싱하기 쉽고 용량 적고 대부분 데이터는 JSON으로 돌아다님
	//XML이 가독성 나쁘지않음

public String getCoffee2(HttpServletRequest request) {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		con = MsDBManager.connect("msPool");
		String sql = "select*from jun08_coffee";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<jun08_coffee>");//<테이블명>
		
		while (rs.next()) {
			sb.append("<coffee>");//<뭐>
									//<필드명>값</필드명>
			sb.append("<coffee_name>"+rs.getString("coffee_name")+"</coffee_name>");
			sb.append("<coffee_price>"+rs.getInt("coffee_price")+"</coffee_price>");
			sb.append("</coffee>");//</뭐>
			
			
		}
		sb.append("</jun08_coffee>");//</테이블명>
		return sb.toString();
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}finally {
		MsDBManager.close(con, pstmt, rs);
		
		
	}
	
	
}
public String getCoffee3(HttpServletRequest request) {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		con = MsDBManager.connect("msPool");
		String sql = "select*from jun08_coffee";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		StringBuffer sb = new StringBuffer();
		sb.append("[");//<테이블명>
		boolean first=true;
		while (rs.next()) {
			if (first) {
				first=false;
			}else {
				sb.append(",");
			}
			sb.append("{");//<뭐>//<필드명>값</필드명>
			sb.append("\"coffee_name\":\""+rs.getString("coffee_name")+"\",");
			sb.append("\"coffee_price\":"+rs.getInt("coffee_price"));
			sb.append("}");
			
		}
		sb.append("]");//</테이블명>
		return sb.toString();
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}finally {
		MsDBManager.close(con, pstmt, rs);
		
		
	}
	
	
}

}
