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
	// ��Ű�� �ѱ� ���� �ȵƾ���
	//	��->%2A�� �ٲ�� �����߾���
	// �����ڵ��� �����Ƽ� ID�� �ѱ� �������߾��µ�
	//->����
	//���� ���̵� ����ȭ�� ��Ű
	%>
	<form action="LoginController" name="loginf" method="post"
		onsubmit="return loginCheck();">
		id:<input name="id" value="${cookie.lastloginedID.value }">
		<p>
			pw:<input name="pw" type="password" maxlength="12">
		<p>
			<button>�α���</button>
	</form>
</body>
</html>