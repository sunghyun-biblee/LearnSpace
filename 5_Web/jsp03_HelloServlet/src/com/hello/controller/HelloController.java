package com.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloController extends HttpServlet {
	public HelloController() {
		System.out.println("servlet 생성자");
	}
	
	@Override
	public void init(ServletConfig config) {
		System.out.println("servlet init()");
		// config : 서브릿이 초기화되는 동안 참조해야 할 정보를 전달해 주는 역할
		
		System.out.println("context param: "+ config.getServletContext().getInitParameter("url"));
		System.out.println("init param : "+config.getInitParameter("driver"));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("get방식");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8	");
		
		String command=request.getParameter("command");
		System.out.println("파라미터 command 값 : "+ command);
		
		PrintWriter out = response.getWriter();
		out.println("<h1 style='background-color:skyblue;'> HelloServlet</h1>");
		out.println("<h2> servlet 라이프 사이클, url mapping <h2>");
		out.println("<a href='home.html'>돌아가기 <a>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("post방식");
		
		doGet(request,response);
	}
	
	@Override
	public void destroy() {
		System.out.println("servlet destory()!");
	}
	
	
}
