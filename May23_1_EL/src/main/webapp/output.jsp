<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ms.may231el.main.Doge"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	//.jsp(v)웹디자이너-프로그래밍쪽 하는 사람(x)
	//근데 지금 java소스가..
	//=>.jsp에서 java소스 없애자
	//웹 디자이너가(Front-end) 하기에는 자바가 어려우니->EL/CustomTag
	//자바보다 쉬운
	//.jsp에 java소스 쓸 일이 뭐가
	//		1)값 받기- EL
	//		2)for- CustomTag
	//		3)출력 형식
	//		...

	//EL(Expression Language)
	//	값 받을 때 Java대신 사용가능한
	//	java아님,tomcat이 Java로 바꿔줌->.jsp에서만 가능
	//  연산자 사용가능
	//	형변환 자동가능
	//  값 없으면 없는거
	//  import없어도 됨
	//  ${???}
	//	req param:${param.파라메터명}
	//	기본형급:req attr :${어트리뷰트명}
	// 	객체급:${어트리뷰트명.멤버변수명}:사실은 getter쓰는거
	//	ArrayList<객체>:${어트리뷰트명[인덱스].멤버변수명}

	String birth = request.getParameter("b");
	int age = (Integer) request.getAttribute("agee");
	Doge d = (Doge) request.getAttribute("ddd");
	ArrayList<Doge> doges = (ArrayList<Doge>) request.getAttribute("doges");
	%>
	생일:<%=birth%><br> 나이:<%=age%><br>
	<%=d.getPrice()%><br>
	<%=d.getName()%><br> 주소값:<%=doges%><br>
	<%
	for (Doge dddd : doges) {
	%>
	<%=dddd.getName()%>
	<%=dddd.getPrice()%><br>


	<%
	}
	%>
	<hr>
	생일:${param.b}
	<br> 나이:${agee }
	<br> ${agee+10 }
	<br> ${adsasdsadas } ${ddd.price } ${ddd.name }
	<br>${doges }<br>${doges[0] }<br>${doges[0].name },${doges[0].price }

</body>
</html>