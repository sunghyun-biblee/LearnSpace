package com.mvc.upgrade;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
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
		System.out.println(dto.getMemberpw());
		System.out.println(res.getMemberpw());
		if(res!=null) {
			//db 에 저장되어 있는 password와 화면에서 입력한 password가 일치하는지 확인
			if(passwordEncoder.matches(dto.getMemberpw(), res.getMemberpw())) {
				//아이디값만 일단 가져오고 이후 비밀번호값을 암호화한 비밀번호값과 , 유저가 입력한 비밀번호값이 동일한지 비교
				//매개변수로 넘어오는 객체의 pw값 (유저가 입력한 값,타이핑한 값 그대로) 과, biz.login()으로 확인한 객체의 pw값(encoding되어 저장되어있는 값)을 비교
				session.setAttribute("login", res); // 객체가 들어있으면 session객체에 res를 담는다.
				check=true;
			}
		
			
		}
		
		Map<String,Boolean> map=new HashMap<>();
		map.put("check", check);
		// @ResponseBody를 선언해주었으므로 리턴해줄 때 자바객체인 map을 response객체에 json객체로 변환하여 담아준다.
		return map;
	}
	
	@RequestMapping("/registform.do")
	public String memberInsertform() {
		logger.info("REGISTFORM.DO");
		return "mvcregister";
	}
	
	@RequestMapping("/register.do")
	public String memberInsert(MemberDto dto) {
		logger.info("REGISTER");
		// 전달받은 dto 객체 안에 id,pw,name값이 들어있다.
		// dto안에 pw 값을 참조(get) 하여 암호화하여 저장(set)
		dto.setMemberpw(passwordEncoder.encode(dto.getMemberpw()));
		// @Autowired로 passwordEncoder의 객체를 자동생성
		System.out.println(dto.getMemberpw());
		
		int res=biz.insert(dto);
		
		if(res>0) {
			return "redirect:loginform.do"; //회원가입이 됐으니 바로 로그인할 수있도록 로그인화면으로 리다이렉트 시켜서 이동
		} else {
			return "redirect:registerform.do";
		}
	
	}
}
