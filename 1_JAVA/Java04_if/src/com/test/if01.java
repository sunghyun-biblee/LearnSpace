package com.test;

import java.util.Scanner;

public class if01 {

	public void ifTest01() {
		// 단독 if문
		// 조건식의 결과값이 true 이면 { }안에 있는 코드를 실행
		// 조건식의 결과값이 false이면 { }안에 있는 코드를 무시하고 넘어감.

		int num = 0;

		// 짝수인지 조건을 통해 확인 후 출력문으로 출력
		if (num % 2 == 0) {
			// 조건이 참일때 수행
			System.out.println("짝수입니다.");
		}

		// 짝수가 아닌지 조건을 확인함 (즉, 홀수인지 확인 )
		if (num % 2 == 1) {
			System.out.println("홀수입니다.");
		}

		System.out.println("종료");

	}

	public void ifTest02() {
		// if ~ else
		// 둘 중 하나를 선택하는 조건문을 통해, 조건이 참인경우와 거짓인 경우에 따라 하나를 수행

		int num = 25;

		if (num % 2 == 0) {
			// 조건이 참일때 실행할 구문
			System.out.println("짝수입니다.");
		} else {
			// 조건이 거짓일때 실행할 구문
			System.out.println("홀수입니다. ");
		}
		System.out.println("종료");

	}

	public void ifTest03() {
		// 50보다 큰 수라면 "50 초과 입니다", 50보다 작으면 "50 미만 입니다"를 출력
		// 50보다 큰 수일때 (50이상) 짝수면 "50보다 큰 짝수" , 홀수면 " 50보다 큰 홀 수"

		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력해주세요");
		int num = sc.nextInt();

		if (num > 50) {
			System.out.println("50 초과 입니다.");
		} else {
			System.out.println("50 미만 입니다.");
		}

		if (num >= 50) {
			if (num % 2 == 0) {
				System.out.println("50보다 큰 짝수");
			} else if (num % 2 != 0) {
				System.out.println("50보다 큰 홀수");
			} else {
				System.out.println("실수일 수도 있습니다");
			}
		} else {
			System.out.println("50 미만 입니다");
		}
	}
	
	public void ifTest04() {
		// 정수 하나 입력 받아 양수인지 음수인지 출력
		// 단 , 0 이면 "0입니다" 라고 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력해주세요");
		
		int num = sc.nextInt();
		
		if(num==0) {
			System.out.println("0 입니다");
		}else if(num%2==0) {
			System.out.println("짝수 입니다");
		}else if(num%2!=0) {
			System.out.println("홀수 입니다.");
		}
		
	}

}
