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
int x=Integer.parseInt(request.getParameter("x")); 

int y=Integer.parseInt(request.getParameter("y"));
int bigger=0;
if(x>y){
	bigger=x;
	
}else if(x<y){
	bigger=y;
}


%>
<h1>ū��:<%=bigger%></h1>



</body>
</html>