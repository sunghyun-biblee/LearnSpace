package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		Person w = context.getBean("woman",Person.class);
		Person m = context.getBean("man",Person.class);
		
		System.out.println("여학생 기상");
		w.classWork();
		System.out.println("----------------");
		System.out.println("남학생 기상");
		m.classWork();
	}

}


// 메소드 호출이 된다 > proxy가 호출을 가로챈다 > 확인하고 target에 맞춰서 각각 현재 설정을 해둔 advice를 끼워서맞춘다.