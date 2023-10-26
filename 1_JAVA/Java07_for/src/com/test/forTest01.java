package com.test;

import java.util.Scanner;

public class forTest01 {

	public static void main(String[] args) {
//		forTest01.testFor1();
//		forTest01.testFor2();
//		forTest01.testFor3();
		forTest01.testFor4();

	}

	public static void testFor1() {
		// 1~10 출력
		for (int i = 1; i <= 10; i++) {
			System.out.println("i : " + i);
		}
	}

	public static void testFor2() {
		// 10~1 역순 출력
		for (int i = 10; i >= 1; i--) {
			System.out.println("i : " + i);
		}

		// 반드시 1씩 증감할 필요 없음
		for (int i = 1; i < 10; i += 2) {
			System.out.println("2씩 증가" + i);
		}

		// 초기식, 증감식은 1개 이상 기입 가능
		for (int i = 0, j = 10; i < 10 && j > 0; i++, j--) {
			System.out.println(i + "번째");
			System.out.println(j + "번째");
		}

		// char는 유니코드에 해당하는 숫자로 인식하여 실행 가능
		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.println((int) ch);
		}

		int i = 0;
		for (;;) {
			System.out.println(i);
			i++;
			if (i == 3) {
				break;
			}
		}

	}

	public static void testFor3() {
		// 정수를 하나 입력받아 그 수 가 양수 일떄만 그 수의 구구단을 출력
		// 양수가 아니면 " 반드시 1~9 사이의 양수를 입력해야 합니다" 를 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("1~9 사이의 정수입력 : ");
		int num = sc.nextInt();
		int sum = 0;
		if (num >= 1 && num < 10) {
			for (int i = 1; i < 10; i++) {
				sum = num * i;
				System.out.println(num + " * " + i + " : " + sum);
			}
		} else {
			System.out.println("반드시 1~9 사이의 양수릅 입력해야 합니다");
		}

	}

	public static void testFor4() {
		// 1부터 100사이의 정수 중에 임의의 난수를 구한다음
		// 1~난수 까지의 합계를 구해라
		int random = (int) (Math.random() * 100) + 1;
		int sum = 0;

		System.out.println("랜덤으로 나온 난수" + random);
		for (int i = 1; i <= random; i++) {
			sum = sum + i;
			System.out.println(sum);
		}

	}

}