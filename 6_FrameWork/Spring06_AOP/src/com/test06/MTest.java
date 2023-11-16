package com.test06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("com/test06/applicationContext.xml");
		
		
		System.out.println("여학생 기상");
		context.getBean("woman",Person.class).classWork();
		System.out.println("-----------");
		System.out.println("남학생 기상");
		context.getBean("man",Person.class).classWork();
	}

}
