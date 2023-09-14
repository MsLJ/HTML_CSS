<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${sessionScope.loginMember!=null }">
		<form action="SnsWriteController" name="snsWriteForm"
			onsubmit="return snsWriteCheck();">
			<table id="snsWriteTb">
				<tr>
					<td align="center"><textarea name="txt" maxlength="200"
							placeholder="�Է��ϼ��� �ִ�(200��)"></textarea></td>
				</tr>
				<tr>
					<td align="center"><input name="token" type="hidden"
						value="${token }">
						<button>����</button></td>
				</tr>
			</table>
		</form>
	</c:if>
	<form action="SnsSearchController">
		<table id="snsSearchArea">
			<tr align="right">
				<td colspan="3" align="right"><input name="search" type="text"
					maxlength="30" placeholder="������ �Է����ּ���">
					<button>�˻�</button></td>
			</tr>
		</table>
	</form>
	<c:forEach var="sm" items="${smg }">
		<table class="smgTb">
			<tr>
				<td class="td2" align="left">${sm.writer }</td>
			</tr>
			<tr>
				<td class="td1" align="left" rowspan="3"><img
					src="joindata/${sm.photo }"></td>
			</tr>
			<tr>
				<td class="td4">${sm.txt }</td>
			</tr>
			<tr>
				<td class="td5">
				<c:forEach var="sr" items="${sm.replys }">
						<c:choose>
							<c:when test="${sessionScope.loginMember.id==sr.writer }">
								<span class="snsReplyWriter" ondblclick="deleteReply(${sr.no});">${sr.writer }:</span>


							</c:when>
							<c:otherwise>
								<span class="snsReplyWriter">${sr.writer }:</span>


							</c:otherwise>

						</c:choose>
						${sr.txt }-
						<fmt:formatDate value="${sr.date }" type="both" />
						<br>
					</c:forEach> <c:if test="${sessionScope.loginMember !=null }">
						<form action="SnsReplyController"
							onsubmit="return snsREChek(this);">
							<input name="token" value="${token }" type="hidden"> <input
								name="re_no" value="${sm.no }" type="hidden"> <span
								class="snsReplyWriter">"${sessionScope.loginMember.id }"</span>
							<input name="txt">
							<button>����</button>
						</form>
					</c:if></td>
			</tr>


			<tr>
				<td class="td3"><fmt:formatDate value="${sm.date }" type="both" /></td>
			</tr>
		

				<tr>
					<td align="right" colspan="2" class="td5">
						<button class="update"
							onclick="updateSNSMsg(${sm.no},'${sm.txt}');">����</button>
						<button class="delete" onclick="deleteSNS${sm.no};">����</button>
					</td>
				</tr>

			
		</table>

	</c:forEach>



	<c:if test="${page !=1}">
		<a href="SnsPageController?page=${page-1}" class="snsL">&lt;</a>
	</c:if>
	<c:if test="${page!= pageCount }">
		<a href="SnsPageController?page=${page+1}" class="snsR">&gt;</a>
	</c:if>



</body>
</html>