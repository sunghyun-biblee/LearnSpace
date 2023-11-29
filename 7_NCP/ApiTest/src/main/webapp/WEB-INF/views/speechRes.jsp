<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		let res=${res};
		console.log(res);
		$("div").append("<h3>"+res.text+"</h3>");
		
	})
</script>
</head>
<body>
<h1>speech Result</h1>
<div></div>
</body>
</html>