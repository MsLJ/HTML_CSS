<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<table id="reviewArea" border="1">
		<tr>
			<td colspan="3" align="right"><a href="WriteReviewController">글쓰기</a></td>
		</tr>
		<tr>
			<td align="center">

				<table>

					<tr>
						<th class="th1">번호</th>
						<th class="th1">제목</th>
						<th class="th1">날짜</th>
					</tr>
					<c:forEach var="m" items="${msgs }">
						<tr class="dataTr" onclick="goBBSDetail(${m.no});">
							<td align="center">${m.no }</td>
							<td>${m.title }</td>
							<td class="datadate" align="center">${m.date }</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<fmt:formatDate value="${m.date}" type="date" dateStyle="short" />

		<tr>
			<td colspan="3" align="center"><c:forEach var="p" begin="1"
					end="${pageCount}">
					<a href="BBSPageController?page=${p }" class="page">${p}</a>
				</c:forEach></td>
		</tr>

	</table>


</body>
</html>