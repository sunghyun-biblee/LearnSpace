<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
    <% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>result</h1>
	
	pageId : <%=pageContext.getAttribute("pageId") %> <br>
	reqId : <%=request.getAttribute("reqId") %> <br>
	sessionId : <%=session.getAttribute("sessionId") %><br>
	applicationId : <%=application.getAttribute("appId") %>
</body>
</html>