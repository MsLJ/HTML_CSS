<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	//.jsp���� java�ҽ� ������
	// 	���ޱ�:EL
	//������:CustomTag
	//CustomTag
	//jspǥ�ؾ׼��±�:�⺻ ��밡��
	//����Ŀ�����±�
	//JSTL(JSP Standatd Tag Library)
	//core-for/if
	//formatting-��������
	//functions-���ڿ� ���� �޼ҵ�
	//?
	//?
	//���� ����Ŵ� attribute���
	%>
	<c:if test="${num>5 }">
		<h1>5���� ŭ</h1>
	</c:if>
	<hr>
	<c:choose>
		<c:when test="${jn=='Ȧ����~' }">
			<h1>${num}��${jn }</h1>

		</c:when>
		<c:when test="${jn=='ȣ�ü�~' }">
			<h1>��</h1>
		</c:when>
		<c:otherwise>
			<h3>${num }��${jn }</h3>


		</c:otherwise>
		<hr>



	</c:choose>
	<hr>
	<c:forEach var="i" begin="2" end="20" step="3">
	<h2>${i }</h2>
	</c:forEach>
	<hr>
	
		<c:forEach var="h" items="${hum }">
		${h.name }:${h.age }
		
		</c:forEach>





</body>
</html>