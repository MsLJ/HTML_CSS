<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- 
(include빼고)
css/js/그림파일/...상대경로가.jsp기준x
C기준(webapp폴더)기준
 -->
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/calc.css">
<link rel="stylesheet" href="css/bb.css">
<script src="js/may242ck.js" type="text/javascript"></script>
<script src="js/ckh.js" type="text/javascript"></script>
</head>
<body>
	<table id="site">
		<tr>
			<td id="siteTitle">제목</td>

		</tr>
		<tr>
			<td  id="siteMenu">
			<a id="a1" href="Homecontroller">홈</a>
			<a id="a1" href="TestController">다른친구</a>
			<a id="a1" href="CalculatorController">고객센터</a>
			<a id="a1" href="BBHomeController">숫자야구</a>
			
			
			</td>
		</tr>
		<tr>
		
			<td id="sitecontent" align="center">
			<jsp:include page="${cp }"></jsp:include>
			<img src="img/doll.jpg">
			</td>			
		</tr>

	</table>
	
</body>
</html>