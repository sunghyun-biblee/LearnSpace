<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
    <% response.setContentType("text/html; charset=UTF-8"); %>
    
    <%@ page import="java.util.List"   %>
    <%@ page import="com.login.dto.MyMemberDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MyMemberDto login=(MyMemberDto)session.getAttribute("login");
	//빨간줄이 나오는이유는 attribute로 가져오기때문에 dto형식으로 변환해주면된다.
	if(login==null){ // null 인 상태는 로그인 상태가 아니다
		pageContext.forward("index.jsp");
	}
	List<MyMemberDto> list = (List<MyMemberDto>)request.getAttribute("list");
%>
	<div>
		<span><%=login.getMyname() %>님 환영합니다.(등급:<%=login.getMyrole() %>)</span> <!-- session에 담긴 데이터들을 가져와서 출력 -->
		<a href="logincontroller.jsp?command=logout">로그아웃</a>
	</div>
<h1>회원정보 조회</h1>
<table border="1">
	<col width="50"><col width="100"><col width="100"><col width="100">
	<col width="500"><col width="150"><col width="300"><col width="100"><col width="50">
	<tr>
		<th>번호</th>
		<th>I D</th>
		<th>P W</th>
		<th>이름</th>
		<th>주소</th>
		<th>전화번호</th>
		<th>이메일</th>
		<th>가입여부</th>
		<th>등급</th>
	</tr>
<%
	for(MyMemberDto dto : list){ // 향상된 for문 > list안에 객체갯수만큼 반복하여 함수실행
%>
	<tr>
		<td><%=dto.getMyno() %></td>
		<td><%=dto.getMyid() %></td>
		<td><%=dto.getMypw() %></td>
		<td><%=dto.getMyname() %></td>
		<td><%=dto.getMyaddr() %></td>
		<td><%=dto.getMyphone() %></td>
		<td><%=dto.getMyemail() %></td>
		<td><%=dto.getMyenabled().equals("Y")?"가입":"탈퇴" %></td>
		<td><%=dto.getMyrole() %></td>
	</tr>
<%
	}
%>
	<tr>
		<td colspan="9">
			<button onclick="location.href='adminmain.jsp''">메인</button>
		</td>
	</tr>
</table>
</body>
</html>