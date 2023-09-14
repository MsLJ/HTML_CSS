<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="reviewwritetb" border="1">
		<form action="DataUploadController" method="post" name="dataf"
			onsubmit="return dataCheck();" enctype="multipart/form-data">
			<tr>
				<td><input name="no" value="${f.no }" readonly="readonly"></td>
			</tr>
			<tr>
				<td><input name="title" value="${f.title }"></td>
			</tr>

			<tr>
				<td align="left"><a href="file" /${f.file }>${f.file }다운로드</a></td>
			</tr>
			<tr>
				<td colspan="2"><input name="file" type="file"></td>
			</tr>
			<tr align="right">
				<td><fmt:formatDate value="${f.date }" type="both"
						dateStyle="short" timeStyle="short" /></td>

			</tr>
			<tr>
				<td colspan="2" align="center"><button>수정</button>
		</form>
		<button onclick="deleteData(${f.no});">삭제</button>
		</td>
		</tr>
	</table>

</body>
</html>