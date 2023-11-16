package com.test06;

import org.springframework.stereotype.Component;

@Component 
public class Man implements Person{
// component를 통해 클래스들을 자동으로 bean객체 만듬
	@Override
	public String classWork() {

		System.out.println("컴퓨터를 켜서 MLP에 로그인한다");
		return "스프링";
	}

}
