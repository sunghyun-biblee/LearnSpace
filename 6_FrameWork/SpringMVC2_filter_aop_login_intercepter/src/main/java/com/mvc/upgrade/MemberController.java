package com.mvc.upgrade;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDto;



@Controller
public class MemberController {
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberBiz biz;
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		logger.info("LOGIN FORM");
		return "mvclogin";
	}
	
	@RequestMapping(value="/ajaxlogin.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Boolean> ajaxLogin(HttpSession session, @RequestBody MemberDto dto){ // dto에 id와 비밀번호를 저장한 후에 가져옴
		// @RequestBody : request객체로 넘어오는 데이터를 java객체로 변경 : 데이터를 받아올때 자바객체로 변경하여 가져옴 / JSON(request 객체) > java
		// @ResponseBody : java객체를 response 객체에 binding : 자바에서 데이터를 보낼때 데이터를 변경하여 보냄/ java > JSON (response 객체)
		System.out.println("Login");
		System.out.println(dto.getMemberid()); // 데이터가 잘 넘어오는지 확인
		
		logger.info("login");
		MemberDto res= biz.login(dto); 
		
		boolean check=false;
		if(res!=null) {
			session.setAttribute("login", res); // 객체가 들어있으면 session객체에 res를 담는다.
			check=true;
		}
		
		Map<String,Boolean> map=new HashMap<>();
		map.put("check", check);
		// @ResponseBody를 선언해주었으므로 리턴해줄 때 자바객체인 map을 response객체에 json객체로 변환하여 담아준다.
		return map;
	}
}
