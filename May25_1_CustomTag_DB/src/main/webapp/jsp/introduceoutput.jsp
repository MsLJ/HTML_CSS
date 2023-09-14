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
	//.jsp에서 java소스 없애자
	// 	값받기:EL
	//나머지:CustomTag
	//CustomTag
	//jsp표준액션태그:기본 사용가능
	//사제커스텀태그
	//JSTL(JSP Standatd Tag Library)
	//core-for/if
	//formatting-형식지정
	//functions-문자열 관련 메소드
	//?
	//?
	//뭔가 만든거는 attribute취급
	%>
	<c:if test="${num>5 }">
		<h1>5보다 큼</h1>
	</c:if>
	<hr>
	<c:choose>
		<c:when test="${jn=='홀수요~' }">
			<h1>${num}은${jn }</h1>

		</c:when>
		<c:when test="${jn=='호올수~' }">
			<h1>없</h1>
		</c:when>
		<c:otherwise>
			<h3>${num }은${jn }</h3>


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