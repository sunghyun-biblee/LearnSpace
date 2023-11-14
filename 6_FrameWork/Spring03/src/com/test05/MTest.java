package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory= new ClassPathXmlApplicationContext("com/test05/applicationContext.xml");
		System.out.println("Spring Bean Container 생성 완료");
		
		
// 		기존방식		
//		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/test05/applicatioinContext.xml"));
//		bf.getBean(null);
		
		

		
//		ApplicationContext : 컨텍스트 초기화 시점에 모든 빈을 생성.(미리 빈을 생성해 두고 빈이 필요할때 즉시 사용)
//		BeanFactory : 처음으로 getBean()이 호출된 시점에서야 해당 빈 생성
		
		TV tv= factory.getBean("samsung", SamsungTV.class);

		// 같은 아이디와 같은 클래스는 똑같은 객체로 취급한다 > 객체를 돌려서 쓴다 
		//	> 싱글톤 방식 :객체의 인스턴스를 한개만 생성되게 하는 패턴입니다. 이러한 패턴은 주로 프로그램 내에서 하나로 공유를 해야하는 객체가 존재할 때 
		// 				해당 객체를 싱글톤으로 구현하여 모든 유저 또는 프로그램들이 해당 객체를 공유하며 사용하도록 할 때 사용됩니다.
		TV tv3= factory.getBean("samsung", SamsungTV.class);
		TV tv4= factory.getBean("samsung", SamsungTV.class);
		System.out.println(tv3==tv4);
		System.out.println( tv == tv3 && tv3 == tv4 );
	}

}
