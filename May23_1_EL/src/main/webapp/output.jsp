<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ms.may231el.main.Doge"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	//.jsp(v)�������̳�-���α׷����� �ϴ� ���(x)
	//�ٵ� ���� java�ҽ���..
	//=>.jsp���� java�ҽ� ������
	//�� �����̳ʰ�(Front-end) �ϱ⿡�� �ڹٰ� ������->EL/CustomTag
	//�ڹٺ��� ����
	//.jsp�� java�ҽ� �� ���� ����
	//		1)�� �ޱ�- EL
	//		2)for- CustomTag
	//		3)��� ����
	//		...

	//EL(Expression Language)
	//	�� ���� �� Java��� ��밡����
	//	java�ƴ�,tomcat�� Java�� �ٲ���->.jsp������ ����
	//  ������ ��밡��
	//	����ȯ �ڵ�����
	//  �� ������ ���°�
	//  import��� ��
	//  ${???}
	//	req param:${param.�Ķ���͸�}
	//	�⺻����:req attr :${��Ʈ����Ʈ��}
	// 	��ü��:${��Ʈ����Ʈ��.���������}:����� getter���°�
	//	ArrayList<��ü>:${��Ʈ����Ʈ��[�ε���].���������}

	String birth = request.getParameter("b");
	int age = (Integer) request.getAttribute("agee");
	Doge d = (Doge) request.getAttribute("ddd");
	ArrayList<Doge> doges = (ArrayList<Doge>) request.getAttribute("doges");
	%>
	����:<%=birth%><br> ����:<%=age%><br>
	<%=d.getPrice()%><br>
	<%=d.getName()%><br> �ּҰ�:<%=doges%><br>
	<%
	for (Doge dddd : doges) {
	%>
	<%=dddd.getName()%>
	<%=dddd.getPrice()%><br>


	<%
	}
	%>
	<hr>
	����:${param.b}
	<br> ����:${agee }
	<br> ${agee+10 }
	<br> ${adsasdsadas } ${ddd.price } ${ddd.name }
	<br>${doges }<br>${doges[0] }<br>${doges[0].name },${doges[0].price }

</body>
</html>