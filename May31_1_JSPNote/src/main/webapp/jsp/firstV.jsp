<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function goSecondV() {
		location.href = "SecondController";

	}
</script>
</head>
<body>
	<%
	//request
	//1)<a href="��û�ּ�">���� </a>

	//
	//2)javaScript�� location.href="��û�ּ�";
	//	???�� �ϸ� ��û�ּ������� GET��� ��û
	//3)<form action="��û�ּ�">+<button>
	//	input���� ����or��ư ������ ��û�ּ������� GET/POST��� ��û

	%>
	<h1>FV</h1>
	<h1>hello</h1>
	<a href="SecondController?q=10">SecondV</a>
	<hr>
	<span onclick="goSecondV();">secondV��</span>
	<hr>
	<form action="SecondController">
		<input name="q"><br>
		<button>SeCondV</button>


	</form>
</body>
</html>