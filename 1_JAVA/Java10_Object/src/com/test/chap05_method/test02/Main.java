package com.test.chap05_method.test02;

public class Main {
	public static void main(String[] args) {
		MethodTest mt=new MethodTest();
//		매개변수와 변환값이 없는 메소드 호출
		mt.method1();
		
//		[ 매개변수가 없고 반환값이 있는 메소드 호출 ]
//		1. 메소드의 리턴타입과 일치하는 자료형의 변수에다가 리턴값을 담아서 사용.
		String res=mt.method2();
		System.out.println(res);

//		2. 리턴값을 바로 사용
		System.out.println(mt.method2());
		
//		[ 매개변수가 있고 반환값이 없는 메소드 ]
		mt.method3(10,20);
		mt.method3(10);
		
//		[ 매개변수가 있고 반환값이 있는 메소드 ]
		 System.out.println("res : "+mt.method4(10, 40));
	}
}
