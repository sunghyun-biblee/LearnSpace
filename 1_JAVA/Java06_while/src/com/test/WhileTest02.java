package com.test;

public class WhileTest02 {

	public static void main(String[] args) {
		// 1. 1~100 까지의 숫자를 역순으로 출력
//		WhileTest02.prn01();

		// 2. 1~100 까지의 숫자 중 ,2의 배수만 출력
//		WhileTest02.prn02();

		// 3. 1~100 까지의 숫자 중 , 7의 배수의 갯수와 총합을 구하여 출력해라
		WhileTest02.prn03();

	}

	public static void prn01() {
		System.out.println("[prn01]");
		int i = 100;
		do {
			System.out.println(i);
			i--;
		} while (i <= 100 && i > 0);

	}

	public static void prn02() {
		System.out.println("[prn02]");
		int i = 1;
		do {

			if (i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		} while (i <= 100);
	}

	public static void prn03() {
		System.out.println("[prn03]");
		int i =1;
		int sum=0;
		int count=0;
		do {
			if(i%7==0) {
				count+=1;
				sum+=i;
			}
			i++;
		}while(i<=100);
		System.out.println(sum+" : "+count);
	}
}
