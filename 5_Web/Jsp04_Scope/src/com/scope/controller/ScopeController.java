package com.scope.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class ScopeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ScopeController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[controller]");
		
		String reqVal=(String)request.getAttribute("reqId");
		
		HttpSession session=request.getSession(); // session 객체를 가져올땐 Httpsession을 사용
		String sessionVal=(String)session.getAttribute("sessionId");
		
		ServletContext application =request.getServletContext(); //application 객체를 가져올땐 ServletContext를 사용
		String appVal=(String)application.getAttribute("appId");
		
		System.out.println("Request: "+ reqVal);
		System.out.println("Session: "+ sessionVal);
		System.out.println("Application: "+ appVal);
		
		request.setAttribute("reqId","reqId in servlet"); // request 객체에 값을 저장
		//servlet에서는 pageContext가 없다
		//RequestDispatcher를 사용하여 페이지를 전환
		RequestDispatcher dis= request.getRequestDispatcher("result.jsp");
		// RequestDispathcer 객체에 전환하고자 하는 페이지를 저장 > 객체명.foward(request,response)로 사용
		dis.forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
