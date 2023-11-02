<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mvc.dao.MVCBoardDao"%>
<%@ page import="java.util.List" %>
<%@ page import="com.mvc.dto.MVCBoardDto" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <% %> : 지시자 태그 - jsp 코드 대부분 사용--%>
<%

	String command=request.getParameter("command"); // 서버에서 응답할때 실행
	System.out.println("[command:"+command+"]");
	
	MVCBoardDao dao= new MVCBoardDao();
	
	if(command.equals("boardlist")){
		// 1. 필요 데이터 준비
		List<MVCBoardDto> list=dao.selectAll();
		
		// 2. 페이지 전환
		/*
			페이지 이동 방법
			1. forward : request,response 객체가 유지된다.
						 이용된 url이 화면에 안보인다.
						 1) <jsp:forward>
						 2) pageContext.forward()
						 3) requestDipatcher - servlet에서
			2. redirect : 새로 페이지를 요청한 것과 같은 방식으로 페이지 이동
							request, response 객체가 유지 되지 않는다
		*/
		request.setAttribute("allList",list);
		pageContext.forward("boardlist.jsp"); // 이동할 페이지
	} else if(command.equals("writeform")){
		response.sendRedirect("boardwrite.jsp");
		
	} else if(command.equals("boardwrite")){
		// command가 boardwirte 일떄
		// 함께 넘어오는 데이터(writer, title, content 값)을 받아 db에 저장
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MVCBoardDto dto= new MVCBoardDto();
		
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		
		int res= dao.insert(dto);
		if(res>0){
%>
		<script type="text/javascript">
			alert("글 작성 성공!");
			location.href="mycontroller.jsp?command=boardlist"; // 글 작성했기때문에 확인하기위해 boardlist로 보냄
		</script>
<%
			
		}else{
%>
		<script type="text/javascript">
			alert("글 작성 실패")
			location.href="mycontroller.jsp?command=writeform"; // 다시 글 적으라고 writeform으로 보냄
			
		</script>
	
<%
			
		}
	}
%>
<%--<h1><%=command %></h1> --%>

</body>
</html>