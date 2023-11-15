package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		LgTV tv= (LgTV)context.getBean("LG");
		// component로 생성된 bean객체를 조회시 > getBean(id 값이 아닌 클래스명) 작성 > 단, 첫글자는 소문자로 시작
		// 클래스명으로 가져오지않고 직접 정의해서 사용가능 > @Componenet("LG") 로 작성하면 getBean("LG")로 작성해야 조회 가능
		// @Component로 생성된 bean의 이름은 클래스명과 동일
		
		System.out.println(tv);
		tv.powerOn();
		tv.powerOff();
	}

}
