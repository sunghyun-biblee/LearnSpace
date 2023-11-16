package com.test05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
// annotation으로 aspect 클래스 설정
public class MyAspect {
	
	@Pointcut("execution(public * *(..))")
	public void myClass() {} 
	// pointcut 어노테이션을 사용하여 특정메소드를 포인트컷으로 지정 > 사용방법 : @Before("특정메소드 명") > 포인트컷을 작성할 때 해당 메소드이름을 명시
	// 중복되고 길이가 긴 pointcut 을 짧게 작성가능
	// 여러개 작성 가능
	
	
	
//	<advice 메소드들>
	
	@Before("myClass()") // @pointcut으로 myclass메소드를 pointcut으로 지정
	public void before(JoinPoint join) {
		System.out.println("qr코드를 찍는다");
	}
	
	@After("myClass()") // @pointcut으로 myclass메소드를 pointcut으로 지정
	public void after(JoinPoint join)	{
		System.out.println("침대에 눕는다");
	}
}
