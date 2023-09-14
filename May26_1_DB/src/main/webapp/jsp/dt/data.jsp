<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="reviewArea" border="1">
		<tr>
			<td colspan="3" align="right"><a href="DataUploadController">파일
					업로드</a></td>
		</tr>
		<tr>
			<td>${result }</td>
		</tr>
		<tr>
			<td align="center">

				<table>

					<tr>
						<th class="th1">번호</th>
						<th class="th1">제목</th>
						<th class="th1">날짜</th>
					</tr>
					<c:forEach var="f" items="${files }">
						<tr class="dataTr" onclick="goDataDetail(${f.no});">
							<td align="center">${f.no }</td>
							<td>${f.title }</td>
							<td class="datadate" align="center">${f.date }</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<fmt:formatDate value="${f.date}" type="date" dateStyle="short" />

		<tr>
			<td colspan="3" align="center"><c:forEach var="p" begin="1"
					end="${pageCount}">
					<a href="DatapageController?page=${p }" class="page">${p}</a>
				</c:forEach></td>
		</tr>

	</table>



</body>
</html>