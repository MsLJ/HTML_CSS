<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginController" name="loginF" method="post" onsubmit="return loginCheck();">
		<table id="logintb">
			<tr>
				<th>Login</th>
			</tr>
			<tr>
				<td><input name="id" placeholder="ID" maxlength="12"></td>
			</tr>

			<tr>
				<td><input name="pw" type="password"  placeholder="PW" maxlength="12"></td>
			</tr>

			<tr>
				<td align="center"><button>�α���</button>
					<a href="JoinController">ȸ������</a></td>
			</tr>
		</table>
	</form>

</body>
</html>