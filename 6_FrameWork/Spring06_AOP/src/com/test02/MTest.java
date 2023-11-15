package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Person w = context.getBean("woman",Person.class);
		Person m = context.getBean("man",Person.class);
		
		
		System.out.println("여학생 기상");
		w.classWork();
		System.out.println("----------------");
		System.out.println("남학생 기상");
		m.classWork();
	}

}
