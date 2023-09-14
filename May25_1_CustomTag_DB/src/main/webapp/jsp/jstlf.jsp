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
	//프로제트 만들고 처음 한번만 실행
	//근데 버그가 자주터져서 파일 생성하면 그냥 실행하는쪽으로
	//Shift f5하면 캐시 비우기까지
	%>
	<h1>${a }</h1>
	<hr>
	<h1>
		<fmt:formatNumber value="${a }" type="number" />
	</h1>
	<hr>
	<!-- 
3자리마다,
국가설정에 맞는 통화 기호였는데
이제는 자동으로 설정안해주기에 굳이 안써도 될꺼같다
쓸꺼면 currencysybol에 설정해주고 쓸것
원화표시는 \\두개
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
	#:있으면 있고 없으면 없고
	0:있든 말든 자리 채워
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