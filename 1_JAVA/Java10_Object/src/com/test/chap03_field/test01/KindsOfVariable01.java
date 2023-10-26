package com.test.chap03_field.test01;

// 변수 선언위치에 따른 구분
public class KindsOfVariable01 {
//	클래스 영역에 작성하는 변수 필드
//	필드 == 멤버변수(클래스가 가지는 멤버라는 의미) == 전역변수(클래스 전역에서 사용할 수 있는 변수라는 의미)
	private int globalNum;

	public void testMethod(int num) { // 메소드 영역의 시작
		// 메소드 영역에서 작성하는 변수 = 지역변수
		// 메소드의 괄호안에 선언하는 변수 = 매개변수 (매개변수도 일종의 지역변수)
		int localnum;

//		System.out.println(localnum);
//		오류중 initialized -> 초기화가 안되어있다.
		System.out.println(num);
//		매개변수는 호출시 값이 넘어와서 변경되기 때문에 초기화가 필요 없다.
		
		System.out.println(globalNum); // 필드(전역변수)는 클래스 전역에서 사용 가능하다
		
		
	}// 메소드 영역의 끝
	
	public void testMethod2() {
		System.out.println(globalNum); //전역변수는 다른 메소드에서도 사용 가능
//		System.out.println(localNum); // 지역변수는 해당 지역 (블럭,영역)에서만 사용 가능
		
		
	}


}

