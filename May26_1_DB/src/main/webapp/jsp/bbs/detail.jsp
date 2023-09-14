<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/review.css">
</head>
<body>


	<table id="bbsDetailTbl" border="1">
		<form action="BBSDetailController" method="post" name="modifyf" onsubmit="return modifyCheck();">
		<tr>
			<td><input name="modifyN" value="${bm.no }" readonly="readonly"></td>
		</tr>
		<tr>
			<td><input name="modifyT" value="${bm.title }"></td>
		</tr>

		<tr>
			<td colspan="2"><textarea name="modifyTX">${bm.txt }</textarea></td>
		</tr>
		<tr align="right">
			<td><fmt:formatDate value="${bm.date }" type="both"
					dateStyle="short" timeStyle="short" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><button>수정</button>
				</form>
				<button onclick="deleteBBSMsg(${bm.no});">삭제</button></td>
		</tr>
	</table>













</body>
</html>