<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
    <% response.setContentType("text/html; charset=UTF-8"); %>
    
    <%@ page import="java.util.List" %>
    <%@ page import="com.login.dao.MyMemberDao" %>
    <%@ page import="com.login.dto.MyMemberDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 성공</h1>
<%
	String command=request.getParameter("command");
	System.out.println("[command]: "+command+" ! ");
	
	// dao 한테 일을 시키기 위해 dao 객체를 생성
	MyMemberDao dao= new MyMemberDao();
	
	if(command.equals("login")){
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		
		MyMemberDto dto= dao.login(id,pw); // dto객체를 하나 리턴하기 위해 dto타입의 객체를 생성
		
		// 아이디와 비밀번호를 select로 통해 동일한지 비교 후 있으면 로그인 성공, 없으면 로그인 실패.
		if(dto.getMyid()!=null){ // 아이디값이 null 이 아니면 참
			// request.setAttribute("login", dto);
			// pageContext.forward("main.jsp");
			// request,pageContext는 페이지마다 새로운 객체가 있다 (공유 X) , forward 방식으로 화면을 전환하면 공유한채로 넘어간다
			// 다만 이러한 방식으로 매번 사용하면 번거롭다. 이를 보완한 객체가 session 객체이다
			
			session.setAttribute("login", dto); // 공유하는범위가 브라우저까지 넓혀진다 > request가 페이지마다 한 개라면 session은 브라우저(크롬,파폭,엣지...) 마다 한 개	
			// session scope 세션영역 (브라우저당 하나) : 브라우저를 닫기전까지는 어떤페이지를 넘어가더라도 객체를 그대로 공유한다 (살아있다)
			
			/*
				page 영역 > 하나의 jsp 페이지 내에서만 객체를 공유하는 영역 (pageContext 객체)
				request 영역 > 요청을 받아서 응답하기까지 객체가 유효한 영역 (request 객체 :/ 통신객체)
				session 영역 > 하나의 브라우저 당 1개의 session 객체를 공유하는 영역 (session 객체)
				application 영역 > 같은 어플리케이션 내에서 요청되는 페이지들은 같은 객체를 공유하는 공유하는 영역 (하나의 어플리케이션 당 1개의 application 객체를 생성)
			*/
			
			session.setMaxInactiveInterval(60*60); 
			// session.setMaxInactiveInterval(int second);
			// session에 담긴 객체가 살아있는 시간(유효하는 시간) > 정해진 시간이후 초기화됨 | (60*60) => 1시간
			// session에서 데이터를 꺼냈는데 없다? => 로그아웃 상태 , 데이터를 꺼냈을때 있다? => 로그인 상태
			
			// 등급에 따라 다른페이지로 이동
			if(dto.getMyrole().equals("ADMIN")){
				response.sendRedirect("adminmain.jsp");
			}else if(dto.getMyrole().equals("USER")){
				response.sendRedirect("usermain.jsp");
			}
		
		}else{
%>			
		<script type="text/javascript">
		alert("로그인 실패");
		location.href="index.jsp";
		</script>
<%			
		}
		
		
	}
%>
</body>
</html>