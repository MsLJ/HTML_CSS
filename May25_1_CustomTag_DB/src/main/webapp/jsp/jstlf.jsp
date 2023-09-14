<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	//������Ʈ ����� ó�� �ѹ��� ����
	//�ٵ� ���װ� ���������� ���� �����ϸ� �׳� �����ϴ�������
	//Shift f5�ϸ� ĳ�� �������
	%>
	<h1>${a }</h1>
	<hr>
	<h1>
		<fmt:formatNumber value="${a }" type="number" />
	</h1>
	<hr>
	<!-- 
3�ڸ�����,
���������� �´� ��ȭ ��ȣ���µ�
������ �ڵ����� ���������ֱ⿡ ���� �Ƚᵵ �ɲ�����
������ currencysybol�� �������ְ� ����
��ȭǥ�ô� \\�ΰ�
 -->
	<h1>
		<fmt:formatNumber value="${a }" type="currency" currencySymbol="$" />
	</h1>
	<hr>
	<h1>${b }</h1>
	<hr>
	<h1>
		<fmt:formatNumber value="${b }" type="percent" />

	</h1>
	<hr>
	<!-- 
	#:������ �ְ� ������ ����
	0:�ֵ� ���� �ڸ� ä��
	 -->
	<h1>
		<fmt:formatNumber value="${b }" pattern="#.000" />
	</h1>
	<hr>
	<h1>${now }</h1>
	<hr>
	<h1>
		<fmt:formatDate value="${now }" type="date" dateStyle="long" />
	</h1>
	<h1>
		<fmt:formatDate value="${now }" type="date" dateStyle="short" />
	</h1>
	<h1>
		<fmt:formatDate value="${now }" type="date" dateStyle="medium" />
	</h1>
	<h1>
		<fmt:formatDate value="${now }" type="date" dateStyle="full" />
	</h1>
	<hr>
	<h1>
		<fmt:formatDate value="${now }" type="time" timeStyle="long" />
	</h1>
	<h1>
		<fmt:formatDate value="${now }" type="time" timeStyle="short" />
	</h1>
	<h1>
		<fmt:formatDate value="${now }" type="time" timeStyle="full" />
	</h1>
	<h1>
		<fmt:formatDate value="${now }" type="time" timeStyle="medium" />
	</h1>
	<hr>
	<h1><fmt:formatDate value="${now }" type="both" dateStyle="long" timeStyle="short"/></h1>
	<h1><fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/></h1>
	<hr>
	<h1>
		<fmt:formatDate value="${now }" pattern="yyyy-MM-dd-E" />
	</h1>
	<h1>
		<fmt:formatDate value="${now }" pattern="yyyy/MM/dd/E" />
	</h1>
	<h1>
		<fmt:formatDate value="${now }" pattern="yyyy/MM/dd/hh:mm/E" />
	</h1>








</body>
</html>