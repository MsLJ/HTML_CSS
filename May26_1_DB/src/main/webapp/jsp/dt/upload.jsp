<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="DataUploadController" method="post" name="dataf"
		onsubmit="return uploadCheck();" enctype="multipart/form-data">
		<table id="reviewwritetb">
			<tr>
				<td align="center"><input name="title" placeholder="제목"></td>
			</tr>
			<tr>
				<td align="center"><input type="file" name="file"></td>
			</tr>
			<tr>
				<td align="center">
					<button>업로드</button>
				</td>
			</tr>
		</table>


	</form>



</body>
</html>