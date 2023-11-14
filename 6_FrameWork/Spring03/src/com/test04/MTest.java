package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		
		Developer lee = factory.getBean("leecj",Developer.class);
		Engineer kim= factory.getBean("kimcj",Engineer.class);
		
		System.out.println(lee);
		System.out.println(kim);
		
		
		// constructor
		Developer k = new Developer(new Emp(),"인사");
		Developer k2 = new Developer();
		
		// property
		k2.setEmp(new Emp());
		k2.setDept("총무");
		
		/*
		context.getBean(Class<T>)
		매개변수로 던지는 Class 타입의 인스턴스를 반환하는 것
		SpringLearn learn = context.getBean(SpringLearn.class);


		context.getBean(Class<T> , id값 (BeanName) )
		매개변수로 Class + BeanNaem 을 던지므로 보다 명확하게 객체를 얻어올수가 있다.
		(동일한 Class 타입이 있을수 있기에)
		SpringLearn learn = context.getBean("learn",SpringLearn.class);


		context.getBean( id값 (BeanName) )
		id값만 던지게되면 오브젝트 타입으로 리턴하므로 형변환을 해줘야한다.
		(bean생성할때 id값이 같으면 컴파일 오류를 내므로 2번과 같이 명확하게 얻어올수가 있다.)
 		SpringLearn learn = (SpringLearn)context.getBean("learn");
 */		
	}

}
