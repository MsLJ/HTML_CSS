<%@page import="com.ms.mat223unc.main.Calculator2"%>
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
Calculator2 cc=(Calculator2)request.getAttribute("ccc");

%>

결과는<%cc.getResult();%>


</body>
</html>