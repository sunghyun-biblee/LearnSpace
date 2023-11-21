<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입</h1>
	
	<form action="register.do" method="post">
		<table>
			<tr>
				<th>I D</th>
				<td><input type="text" name="memberid"></td>
			</tr>
			<tr>
				<th>P W</th>
				<td><input type="text" name="memberpw"></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="membername" placeholder="이름을 입력해주세요"></td>
			</tr>
			<tr>
				<td>
				<input type="submit" value="회원가입">
				<input type="button" value="취소" onclick="history.back();"> <!-- history.back() : 뒤로가기 -->
 				</td>
			</tr>
			
		</table>
		
	</form>
	
</body>
</html>