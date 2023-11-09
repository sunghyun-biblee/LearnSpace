<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% request.setCharacterEncoding("UTF-8"); %>
    <% response.setContentType("text/html; charset=UTF-8"); %>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 쓰기</h1>

	<form action="controller.do" method="post">
		<input type="hidden" name="command"	value="boardwrite">
		<table>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"> </td>
			</tr>
			<tr>
				<th>제 목</th>
				<td><input type="text" name="title"> </td>
			</tr>
			<tr>
				<th>내 용</th>
				<td><textarea rows="10" cols="40" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="작성">
					<input type="button" value="취소" onclick="locaiton.href='controller.do?command=list'">
				</td>
			</tr>
			
		</table>
	
	</form>
</body>
</html>