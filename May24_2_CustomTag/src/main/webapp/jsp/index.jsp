<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- 
(include����)
css/js/�׸�����/...����ΰ�.jsp����x
C����(webapp����)����
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
			<td id="siteTitle">����</td>

		</tr>
		<tr>
			<td  id="siteMenu">
			<a id="a1" href="Homecontroller">Ȩ</a>
			<a id="a1" href="TestController">�ٸ�ģ��</a>
			<a id="a1" href="CalculatorController">������</a>
			<a id="a1" href="BBHomeController">���ھ߱�</a>
			
			
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