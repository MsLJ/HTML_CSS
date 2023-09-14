<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="WriteReviewController" method="post" name="writef" onsubmit="return writecheck();">
		<table id="reviewwritetb">
			<tr>
				<td align="center"><input name="writeT" placeholder="제목" ></td>
			</tr>
			<tr>
				<td align="center"><textarea name="writeTX" id="reviewtext"></textarea></td>
			</tr>
			<tr>
				<td align="center">
					<button>작성완료</button>
				</td>
			</tr>
		</table>


	</form>
</body>
</html>