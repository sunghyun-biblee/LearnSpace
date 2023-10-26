package com.silsub1.example;

import java.util.Scanner;

public class ForWhile {
	public static void main(String[] args) {
		ForWhile fw = new ForWhile();
		fw.printstar1();
		fw.printstar2();
		fw.countInputCharacter();
	}

	Scanner sc = new Scanner(System.in);

	public void printstar1() {
		System.out.println("정수하나 입력 : ");
		int a = sc.nextInt();
		if (a > 0) {
			for (int i = 1; i <= a; i++) {
				System.out.println(i);
				if (i == a) {
					break;
				}
				for (int j = 0; j < i; j++) {

					System.out.print("*");

				}
			}
		} else if (a < 0) {
			System.out.println("양수가 아닙니다.");
		}
	}

	public void printstar2() {
		System.out.println("정수입력 : ");
		int num = sc.nextInt();

		if (num > 0) {
			for (int i = 1; i <= num; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else if (num < 0) {
			for (int i = num; i < 0; i++) {
				for (int j = i; j < 0; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else {
			System.out.println("출력기능이 없습니다");
		}

	}

	public void countInputCharacter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 입력 : ");
		String str = sc.next();
		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			if (!((tmp >= 'a' && tmp <= 'z') || (tmp >= 'A' && tmp <= 'Z'))) {
				System.out.println("영문자가 아닙니다.");
				return;
			}
		}
		System.out.println("문자 입력 :");
		char ch = sc.next().charAt(0);
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				count++;
			}

			System.out.println(ch + " 이(가) 포함된 갯수 " + count + "개");

		}

	}
}
//	public void countInputCharacter() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("문자열 입력 : ");
//		String str = sc.next();
//		System.out.println("문자 입력 :");
//		char ch = sc.next().charAt(0);
//		int count = 0;
//
//		
//			for (int i = 0; i < str.length(); i++) {
//				if (str.charAt(i)>64 && str.charAt(i)<123) {
//					if (str.charAt(i) == ch) {
//						count++;
//					}
//				}else {
//					
//					System.out.println(str+" 은(는) 영문자가 아닙니다.");
//					System.exit(0);
//				}
//				
//			}
//			System.out.println(ch + " 이(가) 포함된 갯수 " + count + "개");
//			
//	}
//}