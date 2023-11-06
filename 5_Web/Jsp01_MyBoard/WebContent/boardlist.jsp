<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>   <%-- 한글깨지는것을 방지하기 위해 작성 --%>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="java.util.List" %>
<%@ page import="com.mvc.dto.MVCBoardDto" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<MVCBoardDto> list=(List<MVCBoardDto>)request.getAttribute("allList"); // List<MVCBoardDto>로 형변환 해주어야 오류 안생김
%>
<%-- <h1><%=list.get(0).getWriter() %></h1>--%>
<h1>LIST PAGE</h1>
<table border="1">
	<col width="50px"><col width="100px"><col width="200px"><col width="100px">
	<tr>
		<th>번 호</th>
		<th>이 름</th>
		<th>제 목</th>
		<th>날 짜</th>
	</tr>
	
<% 
	for(int i=0; i<list.size();i++){
%>
	<tr>
	<!-- 리스트의 각 번호 이름 제목 날짜를 가져옴 -->
		<td><%=list.get(i).getSeq() %></td> 
		<td><%=list.get(i).getWriter() %></td>
		<td><a href="mycontroller.jsp?command=boarddetail&seq=<%=list.get(i).getSeq()%>"><%=list.get(i).getTitle() %></a></td>
		<%-- seq 의 primary key값을 이용하여 조회하고자 하는 seq번호를 가져와 해당번호의 내용을 출력--%>
		<td><%=list.get(i).getRegdate() %></td>
	</tr>
<%
	}
%>
	<tr>
		<td colspan="4" align="right">
			<button onclick="location.href='mycontroller.jsp?command=writeform'">글쓰기</button>
		</td>
	</tr>
</table>
</body>
</html>