package com.ms.may251.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.ConnectionPool;

import ms.ljh.db.manager.MsDBManager;

//튜브:Connection
//튜브 대여소:DataSource
//JDBC:누군가가 연결요청을 하면 그때부터 세팅하고..
//		->느림

//ConnectionPool:연결객체를 미리 만들어놨다가
//		누군가가 연결요청하면 그거 주기
// ->빠름

//	다양한 프로젝트
//기존 connection은 요청하면 그때 연결객체를 만들기 시작해서 상당히 속도가 느림
//미리 연결객체를 만들어놓는 ConnectionPool을 쓰자 (이건Tomcat이 주관한거라 java에서는 못씀)

public class DBDAO {
	public static void connectTest(HttpServletRequest request) {

		Connection con = null;
		try {

			con = MsDBManager.connect("msPool");

			request.setAttribute("result", "성공3");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "실패3");
		}
		MsDBManager.close(con, null, null);
	}

	public static void connectTest2(HttpServletRequest request) {
		// context.xml내에 기능 maxTotal:최대 동시 접속자수 maxIdle:접속 객체를 몇개 만들어놓는가
		// 톰캣 설정파일
		// 거기다 객체만들어놓고 쓰는게 가능
		// Servers/context.xml
		// 모든 프로젝트에 다
		// 프로젝트/.../META-INF/context.xml
		// 그 프로젝트에만

		Connection con = null;

		try {
			// context.xml
			Context ctx = new InitialContext();
			DataSource ds // java:comp/env/이름
					= (DataSource) ctx.lookup("java:comp/env/msPool");

			con = ds.getConnection();

			request.setAttribute("result", "연결성공2");

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("result", "연결실패2");
		}

		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void connectTestOld(HttpServletRequest request) {

		Connection con = null;

		try {
			// DB MAKER다양->최종적으로 연결 형식이 다 다르고
			// ->DB메이커별로 드라이버를

			// DB메이커별로 주소형식이 다 다르고
			// ->주소만 봐도 드라이버 알아서 찾아서[쌩 java콘솔 프로그램때]
			// ->.jsp프로젝트에서는 알아서 못찾음
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@195.168.9.65:1521:xe";
			con = DriverManager.getConnection(url, "ljh", "dlwnsgk0108");
			request.setAttribute("result", "연결 성공");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "연결 실패");
		}
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
