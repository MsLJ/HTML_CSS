<%@page import="java.util.Random"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<!-- 
함수를 만들어놨으면 테이블을 중간 중간에 넣는게 아니라 
마지막 부분에만 테이블 만들어서 출력해놓게 설계했으면 됐는데
애초에 설계자체가 글러먹었다   다음에는 
계속 테이블 만들면서 그 중간 중간 계산하고 함수 만들지말고
계산하고 함수를 다 만들고 테이블을 만들것
    -->
<meta charset="EUC-KR">
<title>Insert title here</title>



</head>
<body>

	<% 
	double v = Double.parseDouble(request.getParameter("value"));
	String are = request.getParameter("area");
	%>
	<table>
		<tr>

			<th>반환결과</th>
		<tr>
	</table>
	<table>
		<%
		double result = 0;
		if (are.equals("cm")) {
			result = v * 2.54;
			String.format("1%.f", result);%>
		
		<tr>
			<th><h1><%=v%>CM
				</h1></th>
		</tr>
		<tr>
			<th><h1>=</h1></th>
		</tr>
		<tr>
			<th><h1><%=result %>inch
				</h1></th>

		</tr>

		<%
		} else if (are.equals("m2")) {
		result = v * 3.3058;
		%>
		<tr>
			<th><h1><%=v%>㎡
				</h1></th>
		</tr>
		<tr>
			<th><h1>=</h1></th>
		</tr>
		<tr>
			<th><h1><%=result%>평
				</h1></th>
		</tr>

		<%
		} else if (are.equals("cdu")) {
		result = (v * 9 / 5) + 32;
		%>
		<tr>
			<th><h1><%=v%>℃
				</h1></th>
		</tr>
		<tr>
			<th><h1>=</h1></th>
		</tr>
		<tr>
			<th><h1><%=result%>°F
				</h1></th>
		</tr>

		<%
		} else if (are.equals("kmh")) {
		result = v / 1.609;
		%>

		<tr>
			<th><h1><%=v%>km/h
				</h1></th>
		</tr>
		<tr>
			<th><h1>=</h1></th>
		</tr>
		<tr>
			<th><h1><%=result%>mi/h
				</h1></th>
		</tr>

		<%
		}
		%>


	</table>
</body>
</html>