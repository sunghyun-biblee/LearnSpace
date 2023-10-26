package com.test01;

import java.util.Scanner;

public class Operator02 {
	public static void main(String[] args) {
		// (1) 준비 : 클래스명 변수명 = new 클래스명
		Operator02 op = new Operator02();
		// (2) 실행 : 변수명.메소드명();
//		op.test01();
//		op.test02();
		op.test03();
		// new Operator02().test01();
	}

	// && (그리고, ~면서)
	// || (또는, ~거나)
	// 논리값 && 논리값
	// 논리값 || 논리값
	public void test01() {

		// import 생략 방법
		java.util.Scanner sc = new java.util.Scanner(System.in);

		// 1<= 변수 <= 100 이렇게는 사용 못함 --> 변수 >=1 && 변수<=100
		// 변수가 앞쪽으로 와야함 (비교대상이 앞으로 와야함)

		// && : 모든 조건을 만족해야 한다

		int num = 15;

		System.out.println("1~100의 숫자인지 확인: " + (num >= 1 && num <= 100));

		System.out.println("영어 문자 하나를 입력해주세요 :");
//		String tmp= sc.next();
//		char ch= tmp.charAt(0);

//		 위 과정 생략 한줄로 작성
//		char ch= "A".charAt(0);		
		char ch = sc.next().charAt(0);

//		문자변수 >= 'A' && 문자 변수 <= 'Z' 
//		-> 대문자인지 획인하는 방법

		System.out.println("입력한 영어문자가 대문자인가요? : " + (ch >= 'A' && ch <= 'Z'));

		// || : 여러 조건 중 하나라도 만족하면 된다

		System.out.println("y 또는 Y 입력 : ");
		char ch2 = sc.next().charAt(0);

		System.out.println("영문자 y 인지 확인 :" + (ch2 == 'y' || ch2 == 'Y'));
	}

	public void test02() {
		// 삼항 연산자
		// 항목이 3개 - (조건식) ? (참일때 사용하는 값) : (거짓일 때 사용하는 값);

		int num = 0;
//		String res = (num > 0) ? "양수!" : "양수가 아닙니다!";

//		중첩사용 가능
		String res = (num > 0) ? "양수!" : (num == 0) ? "0입니다!" : "음수입니다!";
		System.out.println(res);
		
	}
	
	public void test03() {
		// 복합대입연산자 ( 산술대입 )
		// +=, -=, *=, /=, %=
		int num= 12;
		
		System.out.println(num+=3);
		System.out.println(num-=3);
		System.out.println(num*=3);
		System.out.println(num/=3);
		System.out.println(num%=3);
		
	}
}
