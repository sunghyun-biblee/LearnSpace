<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %> 
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import ="com.mvc.dto.MVCBoardDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% MVCBoardDto dto =(MVCBoardDto)request.getAttribute("dto"); %>
<h1>BOARD DETAIL</h1>
<table border="2">
	<tr>
		<th>SEQ</th>
		<td><%=dto.getSeq() %></td>
	</tr>
	<tr>
		<th>WRITER</th>
		<td><%=dto.getWriter() %></td>
	</tr>
	<tr>
		<th>DATE</th>
		<td><%=dto.getRegdate() %></td>
	</tr>
	<tr>
		<th>TITLE</th>
		<td><%=dto.getTitle() %></td>
	</tr>
	<tr>
		<th>CONTENT</th>
		<td><textarea rows="10" cols="40" readonly="readonly"><%=dto.getContent() %></textarea> </td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="button" value="수정 " onclick="location.href='mycontroller.jsp?command=boardupdateform&seq=<%=dto.getSeq()%>'">
		<!--  어떤 게시글을 수정할지 정하기위해 게시글번호까지 같이 넘겨준다 -->
		<input type="button" value="삭제 " onclick="location.href='mycontroller.jsp?command=boarddelete&seq=<%=dto.getSeq() %>'">
		
		<!--  <input type="button" value="삭제 " onclick="test();"> 이와 같은 형식으로 작성하여 사용해도 무관--> 
		<input type="button" value="목록 " onclick="location.href='mycontroller.jsp?command=boardlist'">
		</td>
	</tr>
</table>
<script type="text/javascript">
function test(){
	location.href='mycontroller.jsp?command=boardlist'
}</script>
</body>
</html>