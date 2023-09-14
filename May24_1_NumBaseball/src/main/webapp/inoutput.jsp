<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="ck.js" type="text/javascript"></script>
<script src="ckh.js" type="text/javascript"></script>
</head>
<body>

<form name="f" action="HomeController" method="post" onsubmit="return check();">
<table>
<tr><th>숫자 야구</th></tr>
<tr><td>나:<input name="n" placeholder="123" maxlength="3"></td></tr>
</table>
<button>확인</button>
<h1>${s}</h1>
<h1>${b}</h1>
<h1>${t }</h1>
</form>
</body>
</html>