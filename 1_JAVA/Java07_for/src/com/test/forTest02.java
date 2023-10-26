package com.test;

import java.util.Scanner;

public class forTest02 {
	public static void main(String[] args) {
//		forTest02.testFor1();
		forTest02.testFor2();
//		forTest02.testFor3();
//		forTest02.testFor4();
//		forTest02.testFor5();
	}

	public static void testFor1() {
		// 반복문 중첩

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.println(i + "+" + j);

			}

		}

	}

	public static void testFor2() {
		for (int i = 2; i < 10; i++) {
			System.out.println(i + "구구단");
			for (int j = 1; j < 10; j++) {
				int sum = i * j;
				System.out.println(i + "*" + j + "=" + sum);
			}
		}
	}

	public static void testFor3() {
		//
		// *****
		// *****
		// *****
		// *****
		// *****

		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				System.out.print("*");
				System.out.print("(" + i + "," + j + ")");
			}
			System.out.println();
		}
		System.out.println("------------------------------");
	}

	public static void testFor4() {
		// 입력된 줄수와 칸수만큼 출력
		// 단, 줄수와 칸수가 일치하는 위치에는 줄 번호애 대한 정수가 출력
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println("줄 수 : ");
		int row = sc.nextInt();
		System.out.println("칸 수 : ");
		int col = sc.nextInt();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == j) {
					System.out.print(i + 1);
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

	}

	public static void testFor5() {

		// 1 2 3 4 5
		// 6 7 8 9 10
		// 11 12 13 14 15
		// 16 17 18 19 20
		// 21 22 23 24 25

		System.out.println();
		int sum = 1;
		int asum = 0;
		int bsum = 0;
		for (int i = 1; i < 6; i++) {	
			for (int j = 1; j < 6; j++) {
				System.out.print(sum);

				if (i == j || i+j==6) {
					asum += sum;

				}
				
				sum++;
			}System.out.println();

		}
		System.out.println();
		System.out.println();
		
		System.out.println("대각선 총 합 : " + asum);

	}

}
