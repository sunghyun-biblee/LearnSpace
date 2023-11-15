package com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	
	@Before("execution(public * *(..))") // 메소드 실행 전
	public void before(JoinPoint join) { 
		System.out.println(join.getTarget().getClass());
		System.out.println(join.getSignature().getName());
		System.out.println("qr코드를 찍는다.");
	}
	
	@After("execution(public * *(..))")  //리턴전 수행
	public void after(JoinPoint join) {
		System.out.println("침대에 눕는다");
	} 
	 
	@AfterReturning(pointcut="execution(public * *(..))", returning ="returnVal") //리턴 후 수행 > 받아온 리턴값을 출력 > returning
	public void returning(JoinPoint join, Object returnVal) {
		System.out.println(returnVal +" 공부하는 날이었다.");
	}
	
	@AfterThrowing("execution(public * *(..))") // 예외가 발생했을때 수행
	public void throwing(JoinPoint join) {
		System.out.println("주말이었다.");
	}
}
