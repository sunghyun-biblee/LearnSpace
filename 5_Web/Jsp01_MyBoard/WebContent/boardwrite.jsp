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
<h1>WRITE PAGE</h1>
<form action="mycontroller.jsp" method="post">
	<input type="hidden" name="command" value="boardwrite"> <!-- 컨트롤러로 보낼대 command값을 항상 같이 보내야 한다.
	컨트롤러입장에선 command를 받았을떄 그 값이 특정 값이면 그 하위코드를 실행한다 -->
	<table border="1">
		<tr>
			<th>WRITER</th>
			<td><input type="text" name="writer"> </td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td><textarea rows="10" cols="50" name="content"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="등록">
				<input type="text" value="취소" onclick="">
			</td>
		</tr>
	</table>
</form>
</body>
</html>