package com.test01;

public class MTest {

	public static void main(String[] args) {
//		() -> {code};
//		() -> code;  | 코드가 한줄일때 괄호 생략가능
		Test01 test01_1 = () -> {
			System.out.println("test01_1");
		};
		test01_1.prn();
		Test01 test01_2 = () -> System.out.println("test01_2");
		test01_2.prn();

//		(parameter) -> {code};
//		(parameter) -> code;
		Test02 test02_1 = (int n) -> {
			System.out.println("intput: " + n);
		}; // 람다식을이용하여 매개변수로 인트값을 하나 받아서 출력
		test02_1.prn(1);
		Test02 test02_2 = (int n) -> System.out.println("intput: " + n);
		test02_2.prn(3);

//		if문도 람다식을 사용하여 괄호를 생략할 수 있다.
//		if(1>2)
//			System.out.println("11");
//		else
//			System.out.println("22");

//		매개변수의 타입 생략 가능 (매개변수의 타입은 대부분 짐작이 가능하여 생략하는 경우가 많음)
		Test02 test02_3 = (n) -> System.out.println("input: " + n);
		test02_3.prn(3);
//		매개변수가 하나 일경우 괄호 생략 가능
		Test02 test02_4 = n -> System.out.println("input: " + n);
		test02_4.prn(5);

		/*
		 * Test var = n -> System.out.println("input: "+n); ==> Test test = new Test() {
		 * int prn(int n) { System.out.println("input: "+n); } }
		 * 
		 * ==> 실행 var.prn(1);
		 */

//		(parameter) -> {code}; (return 생략)
//		코드가 한줄일땐 매개변수괄호 , 코드괄호 , return 생략 가능
		Test03 test03 = n -> n + n;
		System.out.println(test03.prn(5));

//		(parameter, parameter) ->{code; return val;}; (return 생략불가)
		Test04 test04 = (i, j) -> {
			System.out.println("input: " + i + " and " + j);
			return i * j;
		};
		System.out.println(test04.prn(10, 3));

//		------------------------------
		
		MyCalc sum = (a,b)->a+b;
		MyCalc sub = (a,b)->a-b;
		MyCalc mul = (a,b)->a*b;
		
		int c = 10;
		int d = 3;
		System.out.println(sum.calc(c, d));
		System.out.println(sub.calc(c, d));
		System.out.println(mul.calc(c, d));
		
	}

}
