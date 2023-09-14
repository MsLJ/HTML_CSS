<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/review.css">
<link rel="stylesheet" href="css/reviewwrite.css">
<script src="js/ckh.js" type="text/javascript"></script>
<script src="js/may26ck.js" type="text/javascript"></script>
<script src="js/may26move.js" type="text/javascript"></script>
</head>
<body>
	<table id="siteTitleArea">
		<tr>
			<td align="center"><table id="siteTitle">
					<tr>
						<td>HEAP_OVER_FLOW</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td align="center"><table id="siteMenu">
					<tr>
						<td><a href="Homecontroller">Home</a><a
							href="ReviewController">게시판</a><a href="DataController">자료실</a></td>
					<tr>
				</table></td>
		</tr>

		<tr>
			<td align="center"><table id="sitecontent">
					<tr>
						<td align="center"></td>
						<td><jsp:include page="${cp }"></jsp:include></td>

					</tr>
				</table>
	</table>


	<div id="resultArea">${result }</div>
</body>
</html>