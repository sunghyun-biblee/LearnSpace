package com.test04;

public class Man implements Person{

	@Override
	public String classWork() {
//		강제로 예외발생
//		String s=null;
//		s.length();
		System.out.println("컴퓨터를 켜서 MLP에 로그인한다");
		return "스프링";
	}

}
