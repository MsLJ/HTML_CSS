
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css.css">
</head>
<body>

	
	<table>
		<tr>
			<td>�̸�:${uu.name }</td>
		</tr>
		<tr>
			<td><img src="img/${uu.file }"></td>
		</tr>
		<tr>
			<td>Ű:${uu.height }m</td>
		</tr>
		<tr>
			<td>������:${uu.weight }kg</td>
		</tr>
		<tr>
			<td>�񸸵�:${uu.bmi}%</td>
		</tr>
		<tr>
			<td>���:${uu.result }</td>
		</tr>


	</table>

</body>
</html>