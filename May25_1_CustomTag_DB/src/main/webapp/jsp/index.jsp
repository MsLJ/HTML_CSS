<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<script src="js/may25ck.js" type="text/javascript"></script>
<script src="js/ckh.js" type="text/javascript"></script>
</head>
<body>
	<table id="site">
		<tr>
			<td id="siteTitle">BLUE KOREA</td>
		<tr>
		<tr>
			<td id="siteMenu"><a id="a1" href="HomeController">Ȩ</a> <a
				id="a1" href="IntroduceController">���� �Ұ�</a> <a id="a1" href="JstlfController">ã�ƿ���
					��</a> <a id="a1" href="DBcontroller">������</a></td>
		</tr>

		<tr id="sitecontent" align="center">

			<td><img src="img/teacher.png"><br> 
			<jsp:include page="${cp }"></jsp:include>
			</td>
		</tr>
	</table>


</body>
</html>