<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<form action="JoinController" name="joinF"
		onsubmit="return joinCheck();" method="post"
		enctype="multipart/form-data">
		<table id="joinTb">
			<tr align="center">
				<td><input name="id" placeholder="ID" maxlength="12"></td>
			</tr>
			<tr align="center">
				<td><input type="password" name="pw" placeholder="PW" maxlength="12"></td>
			</tr>
			<tr align="center">
				<td><input name="pwck" placeholder="PW��Ȯ��"></td>
			</tr>
			<tr align="center">
				<td><input name="name" placeholder="�̸�"></td>
			</tr>
			<tr align="center">
				<td><input name="age" placeholder="����"></td>
			</tr>
			<tr align="center">
				<td><input name="addr1" placeholder="�����ȣ" maxlength="5">
					<input name="addr2" placeholder="�ּ�"> <input name="addr3"
					placeholder="���ּ�"></td>
			</tr>
			<tr align="center">
				<td><select name="y">
						<c:forEach var="y" begin="${cy - 131 }" end="${cy }">
							<option>${y }</option>
						</c:forEach>
				</select>�� <select name="m">
						<c:forEach var="m" begin="1" end="12">
							<option>${m }</option>

						</c:forEach>
				</select>�� <select name="d">
						<c:forEach var="d" begin="1" end="31">
							<option>${d }</option>
						</c:forEach>

				</select>��</td>
			</tr>
			<tr align="center">
				<td>����:<input type="file" name="img"></td>
			</tr>
			<tr align="center">
				<td><button>ȸ������</button></td>
			</tr>
		</table>

	</form>



</body>
</html>