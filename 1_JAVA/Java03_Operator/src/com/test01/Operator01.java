package com.test01;

import java.util.Scanner;

public class Operator01 {
	public static void main(String[] args) {
		// static method 호출
		// 클래스명. 메소드명();
		// Operator01.test01();

		// non static method 호출

		// (1) 준비 : 클래스명 변수명 = new 클래스명();
		Operator01 op = new Operator01();

		// (2) 실행 : 변수명.메소드명();
		op.test02();
		op.test03();
	}

	// ! : 논리 부정 연산자
	// !true => false , !false => true
	public static void test01() {
		System.out.println("true의 부정 : " + !true);
		System.out.println("false의 부정: " + !false);

		// 키보드로 정수하나 입력받아 짝수인지 확인해보기
		Scanner sc = new Scanner(System.in);

		System.out.println("정수를 입력해주세요: ");
		int numb = sc.nextInt();

		System.out.println("입력한 정수가 짝수인가요 ? " + (numb % 2 == 0));
		System.out.println("입력한 정수가 홀수인가요 ? " + !(numb % 2 == 0));
//											( numb % 2 != 0 ) , ( numb % 2 == 1 )

	}

	public void test02() {
		// 증감연산자 ++, --

		int age = 25;
		System.out.println("현재 나이가 어떻게 되나요? " + age);

		age++;
		System.out.println("age++ 값은? " + age);

		++age;
		System.out.println("++age 값은? " + age);

		age++;
		System.out.println("age++ 값은? " + age);

		age--;
		System.out.println("age-- 값은? " + age);

		////
		int num1 = 20;
		int num2 = 25;
		// 후위연산자
		// 다른연산(계산)을 먼저 처리 하고 난 뒤 증가 처리
		int res = num1++ * 3;
		System.out.println("num1값은? " + num1);
		System.out.println("res값은? " + res);

		// 전위연산자
		// 증가를 먼저 처리하고 난 뒤 다른 연산(계산)을 한다.
		int res2 = ++num2 * 5;
		System.out.println("num1값은? " + num2);
		System.out.println("res값은? " + res2);

	}

	public void test03() {
		// 비교연산자 : 두개의 값(변수)을 비교하여 조건에 만족하면 true, 아니면 false 반환
		// > , < , == , != , <= , >=
		int a = 10, b = 20;
		boolean res1, res2, res3;

		res1 = (a == b);
		res2 = (a <= b);
		res3 = (a >= b);

		System.out.println("res1의 값은? " + res1);
		System.out.println("res2의 값은? " + res2);
		System.out.println("res3의 값은? " + res3);

	}
	

}
