<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	<jsp:forward page="./mylist.jsp"></jsp:forward> <!-- jsp 액션태그 - jsp에만 존재 (자바문법 대신사용) -->
	<% pageContext.forward("./mylist.jsp"); %>
	 --%>
	<a href="mycontroller.jsp?command=boardlist">글 목록</a>
</body>
</html>