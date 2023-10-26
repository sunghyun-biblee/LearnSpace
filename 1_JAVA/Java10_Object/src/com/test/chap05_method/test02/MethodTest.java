package com.test.chap05_method.test02;

public class MethodTest {
//	매개변수 유무와 반환값 유무에 따른 구분
//
//	반환값이 없다 => void
//	반환값이 있다 => int , String , char ...
	
	
//	1. 매개변수 없고 반환값 없는 메소드
	public void method1() {
		//아무런 값도 반환하지 않고 메소드 내용만 수행 후 리턴값 없이 호출한 메소드로 돌아간다.
		System.out.println("매개변수와 반환값이 둘 다 없는 메소드 입니다.");
		
		return; // 메소드에 생략되어 있음 (jvm이 자동으로 처리)
	}
	
//	2. 매개변수 없고 반환값 있는 메소드
	public String method2() {
		return "매개변수가 없지만 반환값이 있는 메소드 입니다.";
		
	}
	
//	3. 매개변수 있고 반환값 없는 메소드
	public void method3(int a, int b) {
		System.out.println("매개변수 있고 반환값이 없는 메소드");
//		 호출하는 쪽의 괄호에 인자로 넘긴 값을 받기위해 선언하는 것이 매개변수.
//		 선언한 매개변수는 해당 메소드안에서만 사용 가능 하다 (=지역변수)
		int sum=a+b;
		System.out.println("sum : "+sum);
		return;
	}
	public void method3(int a) {
		System.out.println("매개변수 있고 반환값이 없는 메소드");
		
		return;
	}
	
//	4. 매개변수 있고 반환값 있는 메소드
	public int method4(int num1 , int num2) {
//		넘겨 받은 값이 저장된 매개변수를 메소드 내에서 사용할 수 있으며,
//		리턴값으로 메소드 선언시 지정한 타입과 일치하도록 값을 return 해주어야 한다.		
		int sum=num1+num2;
		System.out.println(sum);
		return sum;
	}

}
