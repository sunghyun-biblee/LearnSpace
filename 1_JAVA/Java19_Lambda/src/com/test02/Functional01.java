package com.test02;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Functional01 {

	public static void main(String[] args) {
		unaryTest();
		binaryTest();
		prediTest();
	}

	public static void unaryTest() {
//		unaryOperator -> 특정 type 인자 하나를 받고, 동일 타입 객체를 리턴하는 함수형 인터페이스 (하나받고 하나리턴)
//		apply()를 호출하여 작업수행 (코드 출력, 코드수행 한다)

//		Test01 test01_1= 람다식
		UnaryOperator<String> hello = name -> "Hello," + name;
		System.out.println(hello.apply("biblee"));
	}

	public static void binaryTest() {
//		BinaryOperator는 Type T의 인자 두개를 받고, 동일한 Type T 객체를 리턴하는 함수형 인터페이스입니다.
//		특정 type 인자 두 개를 받고 , 동일 타입 객체로 리턴하는 함수형 인터페이스 (두개 받고 하나리턴)
		BinaryOperator<Integer> sum = (i, j) -> i + j;
		System.out.println(sum.apply(10, 3));
	}

	public static void prediTest() {
//		Predicate : 인자 하나를 받아 ,boolean 으로 리턴하는 함수형 인터페이스
//		test()를 호출하여 작업수행
		Predicate<Integer> p = (n) -> n % 2 == 0;
		if (p.test(5)) {
			System.out.println("짝수입니다");
		} else {
			System.out.println("홀수입니다");
		}

	}

	public static void funcTest() {
//		기본 함수형 인터페이스
//		Function - R apply (T t)    | 매개변수o , 반환값o
//		Function<T, R> | T=> 데이터 타입 , R=> 리턴의 타입
		Function<Integer, String> t = n -> (n < 10) ? "0" + n : "" + n;
		System.out.println(t.apply(1));
		System.out.println(t.apply(11));
		
//		그 외
//		BiFunction - 매개변수 2개, 반환값 o , apply() 사용
//		Supplier - 매개변수 X, 반환값 o , get() 사용 
//		Consumer - 매개변수 o, 반환값 x , accept() 사용
//		BiConsumer - 매개변수 2개, 반환값 x, accept() 사용
	}

}
