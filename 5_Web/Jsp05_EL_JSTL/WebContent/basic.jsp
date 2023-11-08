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
<!-- EL : 데이텨 표현언어 -->
<!--	기존 <%= %>    -->
<!--	el: \${변수/속성}-->

	<h1>EL -Expression Language</h1>
	<table border="1">
		<thead>
			<tr>
				<th>EL Expression</th>
				<th>Result</th>
			</tr>
		</thead>
		
		<tr>
			<td>\${1}</td>  
			<td>${1}</td>
		</tr>
		<tr>
			<td>\${1+2}</td>  
			<td>${1+2}</td>
		</tr>
		<tr>
			<td>\${1+2+3.4}</td>  
			<td>${1+2+3.4}</td>
		</tr>
		<tr>
			<td>\${(1==2)?3:4}</td>  
			<td>${(1==2)?3:4}</td>
		</tr>
	</table>
</body>
</html>