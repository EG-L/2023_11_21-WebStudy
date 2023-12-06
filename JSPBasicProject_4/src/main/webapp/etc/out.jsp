<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="8kb" %>
<%--
	내장 객체 => 미리 객체 생성 후에 사용이 가능하게 만든 것
	=======
	1. 객체명
	2. 클래스
	3. 용도
	4. 주요메소드
	----------------------------------------
	request
	클래스명 : HttpServletRequest
	용도 : 클라이언트 요청 정보 받기
	      클라이언트의 정보 : IP
	      세션이나 쿠키 생성
	      한글변환 (디코딩)
	주요메소드
		getParameter(key명) => 단일값 받기
		getParameterValues(key명) => 다중값 받기(체크박스)
		setCharacterEncoding() => 한글변환 UTF-8
		======================== 전송 Encoding , 수신 Decoding
		getRemoteAddr() => IP
		getCookie() , getSession()
		===========================
		서버 정보
		getRequestURL()
		getRequestURI()
		getContextPath()
		
		http://localhost/ JSPBasicProject_4/etc/out.jsp
		                  =============================
		                              URI
		                  ==================
		                     ContextPath
		=============================================== URL
		추가 정보
		setAttribute() => request에 데이터를 추가해서 넘겨줌
		getAttribute() => 추가된 데이터 읽기
		===========================
		
		Model 1
		JSP <=> JSP
		
		Middle
		
		MV => Java/HTML => EL/JSTL
		
		Model 2
		
		MVC ====> Spring
		
	response
	=========
	클래스명 : HttpServletResponse
	용도 : HTML, Cookie 전송
	      화면 변경
	      헤더 작성
	주요메소드 :
	          response.setContentType
	                   => HTML , XML, JSON 결정
	                     text/HTML , text/XML, text/plain
	          addCookie() => 해당 브라우저로 전송
	          sendRedirect(파일명) => 화면 전송 (GET 방식)
	          setHeader() => 다운로드
	===========================================================
	out : JSPWriter
	      => 출력 버퍼 (HTML을 출력해서 저장하는 공간)
	                =========================
	                | 요청한 브라우저에서 공간의 HTML을 읽어서 출력
	                | 자동으로 비워준다 => 브라우저 한 개만 생성
	                | 기본은 8kb 이지만 buffer를 이용해서 늘려줄 수 있다.
	      => 화면 출력
	         println() / print()
	      => 버퍼 크기
	         getBufferSize()
	      => 남아있는 	버퍼 확인
	         getRemaining()
	      => <%= %>  => ${}
	      => 다운로드=> out.write
	application
	pageContext
	exception
	config
	page
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>out:JSPWriter:버퍼관리</h1>
	1. 전체 버퍼 크기:<%=out.getBufferSize() %><br>
	2. 남은 버퍼 크기:<%=out.getRemaining() %><br>
	3. 사용중인 버퍼 크기:<%=out.getBufferSize()-out.getRemaining() %><br>
	4. &lt;=&gt; 대체 : out.println()/out.write()
	  => 복잡한 HTML을 만들 경우
	  <br>
	  <%
	  	out.println("<h1>OUT객체</h1>");
	  	out.print("<h1>OUT객체</h1>");
	  	out.write("<h1>OUT객체</h1>");
	  %>
</body>
</html>