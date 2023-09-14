<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>

<form name="bbf" action="BBHomeController" method="post" onsubmit="return bbcheck();">
<table>
<tr><th>숫자 야구</th></tr>
<tr><td>나:<input class="bbinput" name="bbn" placeholder="123" maxlength="3"></td></tr>
</table>
<button class="bbbtn">확인</button>
<h1>ST:${s}</h1>
<h1>BA:${b}</h1>
<h1>${t }</h1>
</form>
</body>
</html>