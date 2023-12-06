<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method=post action="upload.jsp" enctype="multipart/form-data">
	<!--                                             업로드 시 사용하는 이름  -->
	파일선택:<input type=file size=20 name=upload>
	<button>파일전송</button>
	</form>
</body>
</html>