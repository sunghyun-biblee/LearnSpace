<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% request.setCharacterEncoding("UTF-8"); %>
    <% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function registForm(){
		location.href="logincontroller.jsp?command=registform"
	}
</script>
</head>
<body>
	<div style="width:300px;">
		<h1 style="text-align:center;">로그인</h1>
		<form action="logincontroller.jsp" method="post"> <!-- action : 어디로 보낼지 , method : 어떤방식으로 보낼지 -->
			<input type="hidden" name="command" value="login"> 
			<table>
				<col width="50"><col width="100">
				<tr>
					<th>I D</th>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<th>P W</th>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="registForm();">
					</td>
				</tr>
			</table> <!-- id,pw를 작성후 submit을 누르면 id값과 pw값 command값 3개가 전달된다. -->
		</form>
	</div>
</body>
</html>