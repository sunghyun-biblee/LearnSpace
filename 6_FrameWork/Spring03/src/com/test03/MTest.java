package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		Developer lee = (Developer) factory.getBean("leecj");
		Engineer kim = (Engineer) factory.getBean("kimcj");
		
		System.out.println(lee);
		System.out.println(kim);
	}

}
