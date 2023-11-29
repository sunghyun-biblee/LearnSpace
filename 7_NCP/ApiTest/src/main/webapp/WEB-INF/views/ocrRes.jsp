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
		console.log(res.images[0].fields[0].name);
		console.log(res.images[0].fields[0].inferText);
		for(let i = 0; i<res.images[0].fields.length;i++){
			let name=res.images[0].fields[i].name;
			let inferText=res.images[0].fields[i].inferText;
			console.log(name);
			console.log(inferText);
			$("div").append("<p>"+name+"</p>");
			$("div").append("<p>"+inferText+"</p>");
		}
	})
</script>
</head>
<body>
<h1>OCR Result</h1>
<div></div>
</body>
</html>