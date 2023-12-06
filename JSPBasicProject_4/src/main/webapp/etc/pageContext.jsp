<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	1. 내장 객체 얻기
		getRequest() , getResponse() , getOut() 
		getSession() , getPage() , getException()
		application => getServletContext()
		=> 사용 빈도가 거의 없다. (99.999999999%)
		
		request.getParameter()
		pageContext.getRequest().getParameter()
     2. 웹 흐름 제어
        include() , forward() => 파일마다 request 공유를 한다.
        pageContext.include() ==> X
        => <jsp:include>
        => 
        	1. <%@ include file=""%> : 정적
        		=> file에는 반드시 file명을 설정한다
        			menu / footer
        	2. <jsp:include page=""> : 동적
        		=> 내용 출력시에 변경
        		   page=변수명
        	=> JSP안에 특정 위치에 다른 JSP를 포함
        	a.jsp
        	 <html>
        	 	<body>
        	 		<%
        	 			int a = 10;
        	 		%>
        	 		<h1><%= a%></h1>
        	 	</body>
        	 </html>
        	 ==================
        	 <html>
        	 	<body>
        	 		<h1>10</h1>
        	 	</body>
        	 </html>
        	 ==================
        	 
        	 b.jsp
        	 <html>
        	 	<body>
        	 		<%
        	 			int a = 100;
        	 		%>
        	 		<h1><%=a%></h1>
        	 		=================================
        	 		<%@ include file="a.jsp"%> => 변수가 들어오기 때문에 동일 변수 에러 발생
        	 		<html>
		        	 	<body>
		        	 		<%
		        	 			int a = 10;
		        	 		%>
		        	 		<h1><%= a%></h1>
		        	 	</body>
		        	 </html>
        	 		=================================
        	 		<jsp:include page="a.jsp"> => HTML로 붙기 때문에 변수가 겹쳐도 상관이 없음
        	 		<html>
		        	 	<body>
		        	 		<h1>10</h1>
		        	 	</body>
		        	 </html>
        	 		=================================
        	 	</body>
        	 </html>
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>