package com.home.view;

import java.util.Scanner;

import com.home.controller.*;

public class Menu {

	public static void displayMenu() {
		Function fc = new Function();
		Scanner sc = new Scanner(System.in);

		
		int j=0;

		do {
			System.out.println("*** 변수/연산자/제어문 연습 프로그램 ***");
			System.out.println();
			System.out.println("1.간단계산기");
			System.out.println("2.작은수에서 큰수까지 합계구하기");
			System.out.println("3.신상정보 확인하기");
			System.out.println("4.학생정보 확인하기");
			System.out.println("5.별과 숫자 출력하기");
			System.out.println("6.난수까지의 합계 구하기");
			System.out.println("7.구구단");
			System.out.println("8.주사위 숫자 알아 맞추기 ");
			System.out.println("9.프로그램 종료");
			System.out.println("메뉴 번호 입력 : ");
			int i = sc.nextInt();
			switch (i) {
			case 1:
				fc.calculator();
				break;
			case 2:
				fc.totalCalculator();
				break;
			case 3:
				fc.profile();
				break;
			case 4:
				fc.sungjuk();
				break;
			case 5:
				fc.printStarNumber();
				break;
			case 6:
				fc.sumRandomNumber();
				break;
			case 7:
				fc.continueGugudan();
				break;
			case 8:
				fc.shutNumber();
				break;
			case 9:
				j=10;
				break;

			}
		} while (j < 10);
//		System.out.println("Q");
	}

}
