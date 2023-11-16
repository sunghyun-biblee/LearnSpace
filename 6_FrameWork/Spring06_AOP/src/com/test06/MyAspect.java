package com.test06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component  // component를 통해 클래스들을 자동으로 bean객체 만듬
@Aspect // annotation으로 aspect 클래스 설정
public class MyAspect {
	
	@Pointcut("execution(public * *(..))") 
	public void test() {
	// pointcut 어노테이션을 사용하여 특정 메소드를 포인트컷으로 지정
	}
	
	@Before("test()")
	public void before(JoinPoint join) {
		System.out.println("qr코드를 찍는다");
	}
	
	@After("test()")
	public void after(JoinPoint join) {
		System.out.println("침대에 눕는다");
	}
}
