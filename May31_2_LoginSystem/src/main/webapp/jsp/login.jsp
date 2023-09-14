<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="js/may31ck.js" type="text/javascript"></script>
<script src="js/may31ckh.js" type="text/javascript"></script>
</head>
<body>

	<%
	// 쿠키에 한글 쓰면 안됐었음
	//	ㅋ->%2A로 바꿔야 가능했었음
	// 개발자들이 귀찮아서 ID에 한글 못쓰게했었는데
	//->관성
	//구글 아이디 동기화도 쿠키
	%>
	<form action="LoginController" name="loginf" method="post"
		onsubmit="return loginCheck();">
		id:<input name="id" value="${cookie.lastloginedID.value }">
		<p>
			pw:<input name="pw" type="password" maxlength="12">
		<p>
			<button>로그인</button>
	</form>
</body>
</html>