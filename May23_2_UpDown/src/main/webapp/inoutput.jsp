<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="HomeController">
<input name="aws" placeholder="${param.aws }">
<button>확인</button><br>
${result}<br>
<br>
</form>


</body>
</html>