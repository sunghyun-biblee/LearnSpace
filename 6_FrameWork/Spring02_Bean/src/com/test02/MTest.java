package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory= new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Address kim = (Address)factory.getBean("kim");
		System.out.println(kim.toString());
		
		Address biblee = (Address)factory.getBean("biblee");
		System.out.println(biblee.toString());
		
	}

}
