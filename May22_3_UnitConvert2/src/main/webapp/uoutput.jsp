
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
			<td>이름:${uu.name }</td>
		</tr>
		<tr>
			<td><img src="img/${uu.file }"></td>
		</tr>
		<tr>
			<td>키:${uu.height }m</td>
		</tr>
		<tr>
			<td>몸무게:${uu.weight }kg</td>
		</tr>
		<tr>
			<td>비만도:${uu.bmi}%</td>
		</tr>
		<tr>
			<td>결과:${uu.result }</td>
		</tr>


	</table>

</body>
</html>