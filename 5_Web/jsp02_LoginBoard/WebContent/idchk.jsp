<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
    <% response.setContentType("text/html;	charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload=function(){
		let id=opener.document.getElementsByName("myid")[0].value;
		
		document.getElementsByName("id")[0].value=id;
	}
	function confirm(bool){
	console.log(bool);
		if(bool=="true"){
			opener.document.getElementsByName("mypw")[0].focus();
			opener.document.getElementsByName("myid")[0].title="Y"
			
		}else{
			opener.document.getElementsByName("myid")[0].focus();
		}
		self.close();
	}
</script>
</head>
<body>
<%
	String idnotused=request.getParameter("idnotused"); // registform 에서 idchk 함수를 실행하여 id의 중복을 확인하고 그 결과값을 logincontroller로 넘겨서 dao.idchk 메소드를 실행후 idnotused값을 받아옴
%>
	<table border="1">
		<tr>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td><%=idnotused.equals("true")?"사용가능한 아이디입니다":"이미사용중인 아이디 입니다." %></td>
		</tr>
		<tr>
			<td><input type="button" value="확인" onclick="confirm('<%=idnotused%>')"> </td>
		</tr>
	</table>
</body>
</html>