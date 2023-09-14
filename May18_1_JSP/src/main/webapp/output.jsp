<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
h1{
color: green;
}
</style>
</head>
<body>
<%
String n=request.getParameter("n");
int a=Integer.parseInt(request.getParameter("a"));
String say=(a>=20)?"어서오세요":"나가";
%>
<h1><%=n %>님 <%=say %></h1>

</body>
</html>