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
	//1)<a href="요청주소">여기 </a>

	//
	//2)javaScript의 location.href="요청주소";
	//	???를 하면 요청주소쪽으로 GET방식 요청
	//3)<form action="요청주소">+<button>
	//	input에서 엔터or버튼 누르면 요청주소쪽으로 GET/POST방식 요청

	%>
	<h1>FV</h1>
	<h1>hello</h1>
	<a href="SecondController?q=10">SecondV</a>
	<hr>
	<span onclick="goSecondV();">secondV로</span>
	<hr>
	<form action="SecondController">
		<input name="q"><br>
		<button>SeCondV</button>


	</form>
</body>
</html>