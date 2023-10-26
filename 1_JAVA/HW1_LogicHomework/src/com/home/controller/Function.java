package com.home.controller;

import java.util.Scanner;

public class Function {
	Scanner sc = new Scanner(System.in);

	public void calculator() {

		System.out.println("첫 번째 정수 : ");
		System.out.println("두 번째 정수 : ");
		System.out.println("연산 문자(+,-,x,/,) 입력 :  ");

		int num = sc.nextInt();
		int num2 = sc.nextInt();
		int sum = 0;
		char ch = sc.next().charAt(0);
		switch (ch) {
		case '+':
			sum = num + num2;
			System.out.println(num + "+" + num2 + "=" + sum);
			break;
		case '-':
			sum = num - num2;
			System.out.println(num + "-" + num2 + "=" + sum);
			break;
		case 'X':
			sum = num * num2;
			System.out.println(num + "X" + num2 + "=" + sum);
			break;
		case 'x':
			sum = num * num2;
			System.out.println(num + "x" + num2 + "=" + sum);
			break;
		case '/':
			if (num2 == 0) {
				sum = 0;
				System.out.println("0으로 나눌수 없습니다.");
				break;
			} else {
				sum = num / num2;
				System.out.println(num + "/" + num2 + "=" + sum);
				break;
			}

		}

	}

	public void totalCalculator() {
		System.out.println("첫번째 정수를 입력해주세요 : ");
		System.out.println("두번째 정수를 입력해주세요 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int sum = 0;
		if (num1 > num2) {
			for (int i = num2; i <= num1; i++) {
				System.out.println(i + sum);
				sum += i;

			}
		} else if (num1 < num2) {
			for (int i = num1; i <= num2; i++) {
				System.out.println(i + sum);
				sum += i;

			}
		}
		System.out.println(sum);

	}

	public void profile() {
		System.out.println("이름을 입력해주세요");
		String name = sc.next();
		System.out.println("나이를 입력해주세요");
		int age = sc.nextInt();
		System.out.println("성별을 입력해주세요");
		String fm = sc.next();
		System.out.println("성격을 입력해주세요");
		String tjdrur = sc.next();

		System.out.println("이름 :" + name);
		System.out.println("나이 :" + age + "세");
		System.out.println("성별 :" + fm);
		System.out.println("성격 :" + tjdrur);

	}

	public void sungjuk() {
		System.out.println("학생이름을 입력하세요");
		String name = sc.next();
		System.out.println("학년을 입력하세요");
		int grade = sc.nextInt();
		System.out.println("반을 입력하세요");
		int cl = sc.nextInt();
		System.out.println("번호를 입력하세요");
		int num = sc.nextInt();
		System.out.println("성별(M/F)을 입력하세요");
		char mf = sc.next().charAt(0);
		System.out.println("성적을 입력하세요");
		double avg = sc.nextDouble();
		System.out.println();
		char rank;

		char sex = (mf == 'm' || mf == 'M' ? sex = '남' : mf == 'f' || mf == 'F' ? sex = '여' : null);

		if (avg >= 90) {
			rank = 'A';
		} else if (avg >= 80 && avg < 90) {
			rank = 'B';
		} else if (avg >= 70 && avg < 80) {
			rank = 'C';
		} else if (avg >= 60 && avg < 70) {
			rank = 'D';
		} else {
			rank = 'F';
		}

		System.out.printf("%d학년 %d반 %d번 %c학생 %s의 점수는 %.1f이고 , %c학점 입니다", grade, cl, num, sex, name, avg, rank);

	}

	public void printStarNumber() {
		System.out.println("정수하나 입력 : ");
		int num = sc.nextInt();
		if (num > 0) {
			for (int i = 1; i <= num; i++) {
				System.out.println(i);
				if (i == num) {
					break;
				}
				for (int j = 0; j < i; j++) {

					System.out.print("*");

				}
			}
		} else if (num < 0) {
			System.out.println("양수가 아닙니다.");
		}

	}

	public void sumRandomNumber() {
		double a = (int) (Math.random() * 100) + 1;
		System.out.println(a);
		int sum = 0;
		for (int i = 1; i <= a; i++) {
			sum += i;

		}
		System.out.println(sum);

	}

	public void continueGugudan() {
		System.out.println("정수를 입력해주세요");
		int num = sc.nextInt();
		if (num > 0) {
			for (int i = num; i < num + 1; i++) {
				for (int j = 1; j < 10; j++) {

					if (j % 3 == 0) {
						continue;
					}
					System.out.println(num + " * " + j + " = " + (num * j));

				}
			}
		} else {
			System.out.println("양수가 아닙니다.");
		}

	}

	public void shutNumber() {
		double num1=(int)(Math.random()*6)+1;
		double num2=(int)(Math.random()*6)+1;
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println();
		
		char ch;
		
		
		do {
			System.out.println("두 주사위의 합을 입력해주세요 : ");
			int offer=sc.nextInt();
			if(offer==num2+num1) {
				System.out.println("맞췄습니다.");
			}else {
				System.out.println("틀렸습니다.");
			}
			
			
			System.out.println("계속 하시겠습니까?");
			char choice=sc.next().charAt(0);
			ch=choice;
			System.out.println(ch);
		}while(!(ch=='n'||ch=='N'));
		
		
	}
	

}
