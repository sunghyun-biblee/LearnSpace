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
	<h1>postCommand 페이지 입니다.</h1>
	
	<table border="1">
		<tr>
			<th>name</th>
			<th>addr</th>
			<th>phone</th>
		</tr>	
		<tr>
			<th>${dto.name }</th>
			<th>${dto.addr }</th>
			<th>${dto.phone }</th>
		</tr>
	</table>
	<!-- 전달받은 dto객체의 데이터를 el표현법을 사용하여 데이터를 가져옴 -->
</body>
</html>