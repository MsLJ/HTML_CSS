<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="loginedTb">
		<tr>
			<td>${sessionScope.loginMember.name }님안녕</td>
		</tr>
		<tr>
			<td>${sessionScope.loginMember.age}살</td>
		</tr>
		<tr>
			<td>${sessionScope.loginMember.birthday}</td>
		</tr>
		<tr>
			<td><img src="joindata/${sessionScope.loginMember.photo}"></td>
		</tr>

		<tr>
			<td colspan="2" align="center"><a href="MemberInfoController"><img src="img/favorite_FILL0_wght400_GRAD0_opsz48.png"></a>
				<a href="LoginController"><img src="img/logout_FILL0_wght400_GRAD0_opsz48.png"></a></td>
		</tr>
	</table>
</body>
</html>