<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%int a = 100; %>
	<h1><%=a %></h1>
	<%-- <%@include file="a.jsp" %> 중복 에러--%>
	<jsp:include page="a.jsp"></jsp:include>
</body>
</html>