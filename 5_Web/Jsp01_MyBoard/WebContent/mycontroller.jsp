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
	} else if(command.equals("boarddetail")){
		int seq=Integer.parseInt(request.getParameter("seq"));
		// String을 int타입으로 변환하기위해 parseint를 사용
		
		// 1. 필요데이터 준비
		MVCBoardDto res=dao.selectOne(seq); // 한개의 데이터 (한 줄)만 가져오기 위해 selectOne 메소드를 사용
		
		// 2. 페이지 전환
		request.setAttribute("dto",res);
		pageContext.forward("boarddetail.jsp"); // forward 방식으로 jsp 전환
		
	}else if(command.equals("boardupdateform")){
		int seq=Integer.parseInt(request.getParameter("seq")); //seq 정보를 가져오기
		MVCBoardDto res=dao.selectOne(seq); // seq와 동일한 값의 데이터를 하나만 가져온다
		
		request.setAttribute("dto",res);
		pageContext.forward("boardupdate.jsp"); // forward 방식으로 jsp 전환
		
	} else if(command.equals("boardupdate")){
		String title=request.getParameter("title"); // 해당 데이터의 값을 가져온다
		String content= request.getParameter("content");
		int seq=Integer.parseInt(request.getParameter("seq"));
		
		MVCBoardDto dto= new MVCBoardDto();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setSeq(seq);
		
		int res=dao.update(dto);
		if(res>0){
%>
			<script type="text/javascript">
			alert("글 수정 성공");
			<%-- location.href="mycontroller.jsp?command=boarddetail&seq="+<%=seq%>; // 글 수정을 성공하였으니 다시 boarddetail 화면으로 돌아가자 (seq값을 포함시켜서 이동)--%>
			location.href="mycontroller.jsp?command=boardlist"; // 글 수정 성공시 목록으로 돌아가기 (수정되었는지 빠르게 확인하기위해)
			</script>
<%
		}else{
%>
		<script type="text/javascript">
			alert("글 수정 실패");
			location.href="mycontroller.jsp?command=boardupdateform&seq="+<%=seq%>; // 실패하면 다시 수정 할 수있도록 updateform으로 이동 (seq값을 포함시켜서 이동)
		</script>
<%
		}
			
	}else if(command.equals("boarddelete")){
		int seq=Integer.parseInt(request.getParameter("seq"));
		
		int res=dao.delete(seq);
		
		if(res>0){
%>
		<script type="text/javascript">
		alert("글 삭제 성공")
		location.href="mycontroller.jsp?command=boardlist"; // commnad의 값 boardlist를 가지고 컨트롤러를 거쳐서 command값이 boardlist인 함수를 실행
		</script>
<%
		}else{
%>		
		<script type="text/javascript">
		alert("글 삭제 실패")
		location.href="mycontroller.jsp?command=boarddetail&seq="+<%=seq%>;
		</script>	
<%
		}
		
		
	}
%>

<%--<h1><%=command %></h1> --%>

</body>
</html>