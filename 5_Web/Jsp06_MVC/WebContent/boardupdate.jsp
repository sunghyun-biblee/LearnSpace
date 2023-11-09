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
	<h1>글 수정</h1>
	<form action="controller.do" method="post">
	<input type="hidden" name="command" value="boardupdate"> <!--  태그만으로는 값을 제대로 전달하기 어렵기떄문에 input 태그를 사용하여 값을 전달  --> 
	<input type="hidden" name="seq" value="${dto.seq }"> <!--원하는 게시물만 수정할 수 있도록-->
	<table border="1">
		<tr>
			<th>번호</th>
			<td>${dto.seq }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${dto.regdate }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${dto.writer }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${dto.title }"> </td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="40" name="content">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정">
				<input type="button" value="취소" onclick="history.back()">
			</td>	
		</tr>
	</table>
</form>
</body>
</html>