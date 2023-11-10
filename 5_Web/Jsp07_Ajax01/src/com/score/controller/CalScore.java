package com.score.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;


@WebServlet("/CalScore")
public class CalScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    
	    String name= request.getParameter("name");
	    int kor = Integer.parseInt(request.getParameter("kor"));
	    int eng = Integer.parseInt(request.getParameter("eng"));
	    int math = Integer.parseInt(request.getParameter("math"));
	    
	    int sum= kor+ eng + math;
	    double avg=sum/3.0;
	    
	    //json-simple : 자바에서 json 처리하기 위한 라이브러리
	    // 대표적인 클래스 JSONObject : json을 추상화한 클래스 . HashMap을 상속 > map이니 key와 value를 함께
	    
	    JSONObject obj = new JSONObject();
	    obj.put("name", name);
	    obj.put("sum", sum);
	    obj.put("avg", avg);
	    System.out.println(obj.toJSONString()); // 저장한 값을 콘솔창에 출력
	    
//	    sendRedrict 나 , requestdispatcher 를 사용하면 페이지가 새로고침 되기때문에 printwirter를 사용
	    PrintWriter out=response.getWriter(); // 내용을 화면에 출력
	    out.println(obj.toJSONString()); // 저장한 값을 화면에 출력
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
