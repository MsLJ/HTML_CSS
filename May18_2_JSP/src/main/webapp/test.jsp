<%@page import="java.util.Random"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<!-- 
�Լ��� ���������� ���̺��� �߰� �߰��� �ִ°� �ƴ϶� 
������ �κп��� ���̺� ���� ����س��� ���������� �ƴµ�
���ʿ� ������ü�� �۷��Ծ���   �������� 
��� ���̺� ����鼭 �� �߰� �߰� ����ϰ� �Լ� ����������
����ϰ� �Լ��� �� ����� ���̺��� �����
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

			<th>��ȯ���</th>
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
			<th><h1><%=v%>��
				</h1></th>
		</tr>
		<tr>
			<th><h1>=</h1></th>
		</tr>
		<tr>
			<th><h1><%=result%>��
				</h1></th>
		</tr>

		<%
		} else if (are.equals("cdu")) {
		result = (v * 9 / 5) + 32;
		%>
		<tr>
			<th><h1><%=v%>��
				</h1></th>
		</tr>
		<tr>
			<th><h1>=</h1></th>
		</tr>
		<tr>
			<th><h1><%=result%>��F
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