package com.test2;

public class Test {
	public void test01(int no) {
		if (no % 5 == 0 || no % 5 == 5) {
			System.out.println("5의 배수입니다 ");
		}
	}

	public void test02(int no) {
		if (no % 2 == 0 && no % 3 == 0) {
			System.out.println("2와 3의 배수입니다 ");
		} else {
			System.out.println("2와 3의 배수가 아닙니다 ");
		}
	}

	public void test03(char ch) {
		if (ch >= 'A' && ch <= 'Z') {
			System.out.println("대문자입니다");
		} else if (ch >= 'a' && ch <= 'z') {
			System.out.println("소문자입니다");
		}
	}

}
