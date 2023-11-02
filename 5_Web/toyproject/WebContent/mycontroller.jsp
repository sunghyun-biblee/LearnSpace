<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.mvc.dao.MVCBoardDao" %> <%-- dao 자바소스를 참조하기위해   --%>
<%@ page import="com.mvc.dto.MVCBoardDto" %> <%-- dto 자바소스를 참조하기위해 --%>
<%@ page import="java.util.List" %> <%-- 자바api : list를 사용하기위해 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String command=request.getParameter("command"); // 서버에서 응답할때 실행한다
	System.out.println("[command] : "+command+"]");
	
	MVCBoardDao dao=new MVCBoardDao();
	
	if(command.equals("boardlist")){
		// 1. 필요 데이터 준비
		List<MVCBoardDto> list=dao.selectAll(); // return 값으로 res를 가져와서 list에 저장
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
//Action으로 넘어온 값을 변경시킨후 JSP 페이지로 넘겨주기 위해서는 
//request.setAttribute() 를 써서 넘겨주고 JSP 페이지에서는 request.getAttribute()를 써서 받아야한다.

		request.setAttribute("allList", list); // request.setAttribute("객체명","객체")
		pageContext.forward("boardlist.jsp");// 이동할 페이지 (결과물> 리스트를 출력시킬 페이지)
	}
	
%>
</body>
</html>