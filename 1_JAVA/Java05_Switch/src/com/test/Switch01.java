package com.test;

import java.util.Scanner;

public class Switch01 {
	public void switchTest01() {

		int no = 2;
		switch (no) {
		case 1:
			System.out.println("Case 1 입니다");
			break;
		case 2:
			System.out.println("Case 2 입니다");
			break;
		case 3:
			System.out.println("Case 3 입니다");
			break;
		default:
			System.out.println("NONE");
//		break를 작성해주지 않으면 해당 case에서 멈추지않고 밑에있는 다른 case까지 다 실행한다
		}
	}

	public void switchTest02() {
//		char 타입의 값을 switch문에 사용(String타입도 가능)
		char ch = 'a';

		switch (ch) {
		case 'a':
			System.out.println("a!!");
			break;
		case 'b':
			System.out.println("b@@");
			break;
		case 'c':
			System.out.println("c##");
			break;
		default:
			System.out.println("d$$");
		}

	}

	public void switchTest03() {
		String st = "cde";

		switch (st) {
		case "abc":
			System.out.println("abc");
			break;
		case "bcd":
			System.out.println("bcd");
			break;
		case "cde":
			System.out.println("cde");
			break;
		default:
			System.out.println("AAA");

		}
	}

	public void switchTest04() {
		// break를 사용하지 않는 경우

		Scanner sc = new Scanner(System.in);

		System.out.print("월 입력 : ");

		int month = sc.nextInt();

		switch (month) {
		case 12:
		case 1:
		case 2:

			System.out.println("겨울");
			break;
		case 3:

		case 4:

		case 5:
			System.out.println("봄");
			break;

		}

	}

}
