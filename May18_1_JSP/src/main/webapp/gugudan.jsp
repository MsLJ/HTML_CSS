<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
table{
float: left;
} </style>
</head>
<body>
	<%
	for (int dan = 2; dan <= 9; dan++) {
	%>
	<table border="1">
		<tr>
			<th><%=dan%>단</th></tr>
			
			<%
			for (int i = 1; i <= 9; i++) {
				int sum = dan * i;
			%>
			<tr>
			<td><%=dan%>x<%=i%>=<%=sum%></td>
		</tr>
	
	<%
	}%>
	</table>  <!-- 반복문 밖에다 table닫아야지 안에서 닫으면 그 다음 내용들이 테이블에 안담김 -->
	<%}
	%>


</body>
</html>