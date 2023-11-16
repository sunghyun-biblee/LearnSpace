package com.edu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


public class MyAspect {
	
	

//	public void viewPoint() {
//	// pointcut 어노테이션을 사용하여 특정 메소드를 포인트컷으로 지정
//	}
//	
////	<advice 메소드들>	
	

	public void before(JoinPoint join) {
		System.out.println("도형의 넓이를 구한다");
	}
	
	
	public void after(JoinPoint join) {
		System.out.println("도형의 넓이를 출력한다");
	}
}
