package com.silsub1;

import java.util.Scanner;

public class Munjae {
	public void test1() {
		Scanner sc = new Scanner(System.in);

		System.out.println("국어 점수를 입력하세요");
		System.out.println("영어 점수를 입력하세요");
		System.out.println("수학 점수를 입력하세요");

		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		;

		int total = kor + eng + math;
		double avg = total / 3.0;

		if (kor >= 40 && eng >= 40 && math >= 40 && avg >= 60) {
			System.out.println("국어 점수는 :" + kor);
			System.out.println("영어 점수는 :" + eng);
			System.out.println("수학 점수는 :" + math);
			System.out.println("총 점수는 :" + total);
			System.out.printf("평균 점수는 :%.1f", avg);
		} else {
			System.out.printf("불합격 업니다.");
		}
	}

	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("***초기 메뉴***");
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");

		System.out.println("4. 삭제");
		System.out.println("7. 종료");
		System.out.println("메뉴번호 입력 :");

		int num = sc.nextInt();

		switch (num) {
		case 1:
			System.out.println("입력메뉴가 선택되었습니다.");
			break;
		case 2:
			System.out.println("수정메뉴가 선택되었습니다.");
			break;
		case 3:
			System.out.println("조회메뉴가 선택되었습니다.");
			break;
		case 4:
			System.out.println("삭제메뉴가 선택되었습니다.");
			break;
		case 5:
		case 6:
		case 7:
			System.out.println("프로그램이 종료됩니다.");
			break;
		default:
			System.out.println("다시입력하십시오");

		}
	}

	public void test3() {

		Scanner sc = new Scanner(System.in);

		System.out.println("정수를 입력하세요");

		int num = sc.nextInt();
		if (num > 0) {
			System.out.println("양수다");
		} else if (num < 0) {
			System.out.println("음수다");
		}

	}

	public void test4() {
		Scanner sc = new Scanner(System.in);

		System.out.println("정수를 입력하세요");
		int num = sc.nextInt();
		String name;

		if (num > 0) {
			if (num % 2 == 0) {
				name = "짝수다";
				System.out.println(name);
			} else if (num % 2 != 0) {
				name = "홀수다";
				System.out.println(name);
			}
		}
	}

	public void test5() {
		Scanner sc = new Scanner(System.in);

		System.out.println("이름를 입력하세요");
		System.out.println("나이를 입력하세요");
		System.out.println("키를 입력하세요");

		String name = sc.next();
		int age = sc.nextInt();
		double height = sc.nextDouble();

		if (name != null && name.length() > 0 && age > 0 && height > 0) {
			System.out.println("이름:" + name);
			System.out.println("나이:" + age);
			System.out.printf("키:%.1f\n", height);
			System.out.printf("확인:%s의 나이는%d이고,키는 %.1fcm이다", name, age, height);

		}

	}

	public void test6() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 a를 입력하세요");
		System.out.println("정수 b를 입력하세요");

		int a = sc.nextInt();
		int b = sc.nextInt();

		if (a > 0 && b > 0) {
			System.out.println("첫 번째 정수:" + a);
			System.out.println("두 번째 정수:" + b);
			System.out.println("a+b : " + (a + b));
			System.out.println("a-b : " + (a - b));
			System.out.println("a*b : " + (a * b));
			System.out.println("a/b : " + (a / b));
			System.out.println("a%b : " + (a % b));

		}

	}

	public void test7() {
		Scanner sc = new Scanner(System.in);

		System.out.println("점수를 입력하세요");

		int num = sc.nextInt();
		char ch;

		if (num > 0 && num >= 90) {
			ch = 'A';
			System.out.println("점수 : " + num);
			System.out.println("학점 : " + ch);
		} else if (num > 0 && num >= 80 && num < 90) {
			ch = 'B';
			System.out.println("점수 : " + num);
			System.out.println("학점 : " + ch);
		} else if (num > 0 && num >= 70 && num < 80) {
			ch = 'C';
			System.out.println("점수 : " + num);
			System.out.println("학점 : " + ch);
		} else if (num > 0 && num >= 60 && num < 70) {
			ch = 'D';
			System.out.println("점수 : " + num);
			System.out.println("학점 : " + ch);
		} else if (num > 0 && num < 60) {
			ch = 'F';
			System.out.println("점수 : " + num);
			System.out.println("학점 : " + ch);
		} else {
			System.out.println("점수를 양수로 다시 입력해주세요");
		}

	}

}
