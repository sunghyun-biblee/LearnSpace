package com.practice;

import java.util.Scanner;

public class Example {

	public void sample01() {
		// 국어(정수),영어(정수),수학(정수),총점(정수),국어(실수)
		// 키보드로 점수를 입력받고, 합계와 평균을 계산하고
		// 세 과목의 점수와 평균을 가지고 합격 여부 처리함
		// 합격의 조건: 세 과목의 점수가 각각 40점 이상이면서 평균이 60점이상이면 합격 아니면 불합격
		Scanner sc = new Scanner(System.in);
		System.out.println("국어점수를 입력하세요");
		System.out.println("영어점수를 입력하세요");
		System.out.println("수학점수를 입력하세요");

		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		int tot = kor + eng + math;

		double avg = tot / 3.0;
		if (kor >= 40 && eng >= 40 && math >= 40 && tot >= 60 && avg >= 60.0) {
			System.out.println("합격입니다");
		} else {
			System.out.println("불합격입니다");
		}
	}

	public void sample02() {
		Scanner sc = new Scanner(System.in);

		System.out.println("학생이름을 입력하세요");
		System.out.println("학년 입력하세요");
		System.out.println("반을 입력하세요");
		System.out.println("번호를 입력하세요");
		System.out.println("성별을 입력하세요");
		System.out.println("성적을 입력하세요");

		String name = sc.next();
		int gra = sc.nextInt();
		int ban = sc.nextInt();
		int num = sc.nextInt();
		char mf = sc.next().charAt(0);
		double avg = sc.nextDouble();

		System.out.println("학생이름 : " + name);
		System.out.println("학년 : " + gra);
		System.out.println("반 : " + ban);
		System.out.println("번호 : " + num);
		if (mf == 'm') {
			System.out.println("남학생");
		} else if (mf != 'm') {
			System.out.println("여학생입니다");
		}

		System.out.printf("성적:%.2f", avg);

	}

	public void sample03() {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		if (num == 0) {
			System.out.println("0 입니다");
		} else if (num > 0) {
			System.out.println("양수 입니다");
		} else if (num < 0) {
			System.out.println("음수 입니다");
		}

	}

	public void sample04() {
		Scanner sc = new Scanner(System.in);

		System.out.println("정수를 입력하세요");
		int num = sc.nextInt();

		String str;

		if (num % 2 == 0) {
			str = "짝수다";
			System.out.println(str);
		} else {
			str = "홀수다";
			System.out.println(str);
		}

	}
}
