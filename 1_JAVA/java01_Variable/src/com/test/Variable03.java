package com.test;

public class Variable03 {
	public static void main(String[] args) {
		//상수 테스트
		int age ;
		final int AGE ; // 상수는 대문자로 많이사용 (변수명은 대소문자 구별함)
		
		age = 25;
		AGE = 25;
	
		System.out.println("age:"+ age);
		System.out.print("AGE:"+ AGE);
		
		age= 21;
//		AGE= 21; -> 에러 발생, 상수는 변경 불가	
//		상수는 한번 값을 기록한 후에는 변경이 불가능하다
		
		
	
	}
}
