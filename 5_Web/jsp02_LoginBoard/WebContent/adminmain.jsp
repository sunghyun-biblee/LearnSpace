<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <% request.setCharacterEncoding("UTF-8"); %>
 <% response.setContentType("text/html; charset=UTF-8"); %>
 
 <%@ page import="com.login.dto.MyMemberDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MyMemberDto dto=(MyMemberDto)session.getAttribute("login");
	//빨간줄이 나오는이유는 attribute로 가져오기때문에 dto형식으로 변환해주면된다.
	if(dto==null){ // null 인 상태는 로그인 상태가 아니다
		pageContext.forward("index.jsp");
	}
%>
	<div>
		<span><%=dto.getMyname() %>님 환영합니다.(등급:<%=dto.getMyrole() %>)</span> <!-- session에 담긴 데이터들을 가져와서 출력 -->
	</div>


</body>
</html>