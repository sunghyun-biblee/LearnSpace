package com.bike.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bike.dao.BikeDao;
import com.bike.dto.BikeDto;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/BikeServlet")
public class BikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    
	    String command=request.getParameter("command");
	    System.out.println("[command: "+command+"]" );
	    
	    if(command.equals("save")) {
	    	response.sendRedirect("bike.jsp");
	    } else if(command.equals("datasave")) {
	    	
	    	String obj=request.getParameter("obj");
	    	System.out.println(obj.length());
	    	
	    	
	    	JsonParser parser = new JsonParser(); // gson 라이브러리 사용
	    	JsonElement element = parser.parse(obj); // string으로 넘어온 obj 객체를 엘리먼트로 변환
	    	List<BikeDto>dtos = new ArrayList<BikeDto>();
	    	
	    	for(int i=0; i<element.getAsJsonObject().get("DATA").getAsJsonArray().size(); i++) {
	    		// 앨리먼트 > 오브젝트 > 데이터가 가지고있는 벨류값을 > 사용할 객체 배열로 바꾸고 그 크기를 가지고옴
	    		JsonObject tmp= element.getAsJsonObject().get("DATA").getAsJsonArray().get(i).getAsJsonObject(); // DATA 가 가지고있는 배열의 수많은 json 데이터 중에 i 번째 json엘리먼트를 가져온다 
	    		// json 앨리먼트는 사용할 수 없기때문에 > 오브젝트로 변환
	    		
	    		String addr_gu = tmp.get("addr_gu").getAsString(); // 오브젝트 상태로 가져오기때문에 string 에 저장하기 위해서 String 타입으로 변경
	    		int contend_id = tmp.get("content_id").getAsInt(); // 값을 가져왔지만 원하는 타입이 아니기 때문에 내가 원하는 타입으로 변경시켜준다.
	    		String content_nm = tmp.get("content_nm").getAsString();
	    		String new_addr = tmp.get("new_addr").getAsString();
	    		int cradle_count=tmp.get("cradle_count").getAsInt();
	    		double longitude = tmp.get("longitude").getAsDouble();
	    		double latitude=tmp.get("latitude").getAsDouble();
	    		
	    		
	    		BikeDto dto = new BikeDto();
	    		dto.setAddr_gu(addr_gu);
	    		dto.setContent_id(contend_id);
	    		dto.setContent_nm(content_nm);
	    		dto.setNew_addr(new_addr);
	    		dto.setCradle_count(cradle_count);
	    		dto.setLongitude(longitude);
	    		dto.setLatitude(latitude);
	    		
	    		dtos.add(dto);
	    	}
	    	
	    	BikeDao dao=new BikeDao();
	    	
	    	int res=dao.insert(dtos);
	    	
	    	PrintWriter out=response.getWriter();
	    	out.println(res == dtos.size());
	    	
	    	
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
