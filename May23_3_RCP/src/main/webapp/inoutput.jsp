<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css.css" >
</head>
<body>


	<table>
		<tr>
			<th align="center">가위바위보</th>
		</tr>
		<tr>

			<td><a href="HomeController?hand=1"> <img  src="img/h1.jpg"></a></td>
			<td><a href="HomeController?hand=2"> <img  src="img/h2.jpg">
			</a></td>
			<td><a href="HomeController?hand=3"> <img src="img/h3.jpg"></a></td>
		</tr>
		<tr>
	<td><a href="HomeController?hand=3"> <img src="img/start.gif"></a></td>
<td><a href="HomeController?hand=3"> <img src="img/start.gif"></a></td>
</tr>
<tr><td><img src=${uh }></td> <td><img src=${ch }></td></tr>
<tr><td>${result }</td></tr>
<tr><td>${wdl }</td></tr>
	</table>

</body>
</html>