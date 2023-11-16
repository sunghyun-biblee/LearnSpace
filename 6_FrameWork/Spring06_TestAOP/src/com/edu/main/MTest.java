package com.edu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.entity.Shape;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/edu/main/applicationContext.xml");
		
		Shape rect= context.getBean("rect",Shape.class);
		Shape tri= context.getBean("tri",Shape.class);
		
		rect.viewSize();
		System.out.println("-----------");
		tri.viewSize();
	}

}
