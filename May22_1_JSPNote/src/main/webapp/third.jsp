<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<%
	String qq = request.getParameter("q");
	int qqq = Integer.parseInt(qq);
	String ww = request.getParameter("w");
	int www = Integer.parseInt(ww);

	//Object ee=request.getAttribute("e");
	//Integer eee=(Integer)ee;
	//int eeee=eee.intValue();
	int eeee = (Integer) request.getAttribute("e");
	Date ffff = (Date) request.getAttribute("f");
	%>
	<h1>공사중</h1>
	<h1>q=<%=qqq%><br>w=<%=www%><br></h1>
	<h1>random=<%=eeee%><br></h1>
	<h1>date=<%=ffff%></h1>

</body>
</html>