package com.test02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object target =null;
		System.out.println("qr코드를 찍는다.");
		
		try {
			target=invocation.proceed();
		} catch (Exception e) {
			System.out.println("주말이었다.");
		} finally {
			System.out.println("침대에 눕는다.");
		}
		
		return null;
	}

}
