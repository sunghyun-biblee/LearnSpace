package com.test;

import java.util.Scanner;

public class WhileTest01 {

	public static void main(String[] args) {
//		WhileTest01 wt = new WhileTest01();
//		wt.testWhile();

		// static 메소드 실행
		// 클래스명. 메소드명();
//		WhileTest01.testWhile();
//		WhileTest01.testWhile02();
//		WhileTest01.testWhile03();
//		WhileTest01.testWhile04();
//		WhileTest01.testWhile05();
//		WhileTest01.testDoWhile01();
		WhileTest01.testDowhile02();
	}

	public static void testWhile() {
		// 초기식
		int i = 1;

		while (i <= 10) {// 조거닉
			// 반복하며 수행할 코드
			System.out.println(i + "번쨰 반복문 수행중..");
			// 증감식
			i++;
		}

	}

	public static void testWhile02() {
		String str = "apple13517964534"; // index(자리번호) = > 0 부터 시작 / 1 씩 증가

		int index = 0; // 초기식
		while (index < str.length()) { // 조건문
			char ch = str.charAt(index);
			// 없는 인덱스 번호로 가게 되면 오류발생 (=> 조건문 범위 조절)
			// testwhile02 처럼 문자열의 인덱스를 가져올때 XXX.length() 함수를 이용하면
			// 매번 조건문의 범위를 조절 할 수고가 줄어든다
			System.out.println(index + "번째 자리 : " + ch + "!"); // 수행코드
			index++; // 증감식
		}

	}

	public static void testWhile03() {
		// 1부터 입력받은 수 까지 정수들의 합
		Scanner sc = new Scanner(System.in);

		System.out.println("정수를 입력하세요 : ");

		int num = sc.nextInt();

		int i = 1; // 초기식

		int sum = 0;

		while (i <= num) { // 조건문
			sum += i; // 실행코드
			i++;

		}

		System.out.println(sum); // 출력문
	}

	public static void testWhile04() {
		int i = 1;
		while (true) {
			System.out.println(i);
			i++;

			// 분기문
			if (i == 10) {
				break;
			}
		}
		System.out.println("종료 후 i 값 : " + i);

	}

	public static void testWhile05() {
		// 반복하며 키보드로 숫자 입력 받기
		// 단, 4가 입력되면 while문 종료
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1~10 숫자 중 아무정수나 입력");
			int num = sc.nextInt();

			if (num == 4) {
				System.out.println("종료");
				break;

			}
		}

	}

	public static void testDoWhile01() {
		int i = 1;

		do {
			System.out.println(i);
			i++;
		} while (i <= 10);
//		}while(i==10); 조건이 처음부터 맞지 않으면 1회 실행 후 종료
	}

	public static void testDowhile02() {
		// 영어 문자열을 입력받아 입력받은 문자열 출력
		// 단 , "end" 라는 문자열을 입력받으면 반복 종료
		Scanner sc = new Scanner(System.in);
		String str = null;
		do {
			System.out.println("문자열 입력 : ");
			str = sc.next();
			System.out.println("str : " + str);
		} while (!str.equals("end")); // equals => 내용을 비교 / 다를때 fasle 같을때 true

	}

}
