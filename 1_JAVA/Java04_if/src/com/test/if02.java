package com.test;

import java.util.Scanner;

public class if02 {
	// else if
	// 조건을 다중조건으로 줄 수 있다.
	//
	public void testElseIf01() {
		int no1 = 10;
		int no2 = 20;

		if (no1 > no2) {
			System.out.println(no1 + "은" + no2 + "보다 크다");
		} else if (no1 < no2) {
			System.out.println(no1 + "은" + no2 + "보다 작다");
		} else if (no1 == no2) {
			System.out.println(no1 + "은" + no2 + "와 같습니다");
		}
	}

	public void testElseIf02() {
		// 점수를 하나 입력받아 등급을 나누어 점수와 등급을 출력합시다
		// 90점 이상은 A등급
		// 90점 미만 , 80점 이상은 B 등급
		// 80점 미만, 70점 이상은 C 등급
		// 70점 미만, 60점 이상은 D 등급
		// 60점 미만은 F 등급으로 나눈다.

		Scanner sc = new Scanner(System.in);

		System.out.println("점수를 입력해주세요 : ");
		int score = sc.nextInt();
		char grade;

		if (score >= 90) {
			grade = 'A';

		} else if (score >= 80 && score < 90) {
			grade = 'B';

		} else if (score >= 70 && score < 80) {
			grade = 'C';

		} else if (score >= 60 && score < 70) {
			grade = 'D';

		} else  {
			grade = 'F';

		}
		
//		printf ==> %형식의 순서대로 값을 출력하기때문에 순서를 잘 작성해야한다
//		%d : 정수 | %o : 8진수 | %x : 16진수
//		%c : 문자 | %s : 문자열
//		%f : 실수(소수점 아래 6자리), %e : 지수형태표현, %g : 대입 값 그대로
//		%A : 16진수 실수
//		%b : 논리형
//		%5d : 5칸을 확보하고 오른쪽 정렬 (출력데이터 앞쪽에 공간을 확보)
//		%-5d : 5칸을 확보하고 왼쪽 정렬 (출력데이터 뒤쪽에 공간을 확보)
//		%.2f : 소수점 아래 2자리까지만 표시
		
//		\t : t갯수만큼 띄어쓰기 (\n5) | \n : 줄 바꿈
		
//		ex) %d 형식의 값에 다른형식(char)의 변수값을 나열하면 오류발생
		
		
		System.out.printf("당신의 점수는 %d이고, 등급은 %c 입니다", score, grade);
	}
}
