<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.StringTokenizer"%>
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
String num=request.getParameter("num");
String[]n2=num.split("\r\n");
//StringTokenizer St=new StringTokenizer(num,"\r\n");
int sum=0;
for(String s:n2){
	try{
	sum+=Integer.parseInt(s);
	}
	catch(Exception e){
		
	}
}

%>
<h1>결과:<%=sum%></h1>


</body>
</html>