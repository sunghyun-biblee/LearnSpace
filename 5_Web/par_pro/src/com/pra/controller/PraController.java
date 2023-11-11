package com.pra.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pra.biz.PraBiz;
import com.pra.biz.PraBizImpl;
import com.pra.dto.PraDto;

@WebServlet("/PraController")
public class PraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String command=request.getParameter("command");
		System.out.println("[command: "+command+"]");
		
		PraBiz biz = new PraBizImpl();
		//getParameter("XXX") > 웹브라우저에서 전송받은 request영역에서 지정한 매개변수의 값을 찾아 읽어오는데
		//getAttribute("XXX","123") > setAttribute()를 통해 값을 설정해준 값을 리턴받는다. 값을 정해주지않은 상태에는 null을 리턴
		
		
		if(command.equals("boardlist")) {
			List<PraDto> list=biz.selectAll();
			
			request.setAttribute("list",list);
			
			RequestDispatcher dis=request.getRequestDispatcher("boardlist.jsp"); // boardlist 페이지로 이동
			dis.forward(request, response); // forward 방식으로 객체를 전달
		}else if(command.equals("writeform")) {
			response.sendRedirect("writeform.jsp");
		}else if(command.equals("boardwrite")) {
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			PraDto dto=new PraDto(0,writer,title,content,null);
			
			boolean res=biz.insert(dto);
			
			PrintWriter out=response.getWriter();
			String str="";
			if(res) {
				str="<script type='text/javascript'>"+"alert('글 작성 성공');"+"location.href='pra.do?command=boardlist';"+"</script>";
				out.println(str);
			}else {
				str="<script type='text/javascript'>"+"alert('글 작성 실패');"+"location.href='pra.do?command=writeform';"+"</script>";
				out.println(str);
			}
			
		}else if(command.equals("detail")) {
			int seq=Integer.parseInt(request.getParameter("seq"));
			
			PraDto dto=biz.selectOne(seq);
			request.setAttribute("dto", dto);
			
			RequestDispatcher dis=request.getRequestDispatcher("boarddetail.jsp");
			dis.forward(request, response);
		}
		
	}
	
	
// 실행 방식이 post 형식으로 전달되어 doPost 메소드가 실행되어도 doGet메소드를 호출하여 doGet에서 작성한 기능들을 수행하도록 함
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
