package com.example;

import java.util.Scanner;

public class Example {
	public static void main(String[] args) {

	}

	public void example01() {
		Scanner sc = new Scanner(System.in);

		int a, b;
		System.out.println("첫 번째 정수");
		System.out.println("두 번째 정수");
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println("더하기 결과:" + (a + b));
		System.out.println("빼기 결과:" + (a - b));
		System.out.println("곱하기한 결과:" + (a * b));
		System.out.println("나누기한 몫 결과:" + (a / b));
		System.out.println("나누기한 나머지 결과:" + (a % b));

	}

	public void example02() {
		Scanner sc = new Scanner(System.in);
		double a, b;
		System.out.println("세로:");
		System.out.println("가로:");
		 
		a = sc.nextDouble();
		b = sc.nextDouble();

		System.out.println("면적: " + (a * b));
		System.out.println("둘레: " + ((a + b) * 2));

	}
	
	public void example03() {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열을 입력하시오 ");
		
		String a=sc.next();
		
		System.out.println("첫 번째 문자:"+a.charAt(0));
		System.out.println("두 번째 문자:"+a.charAt(1));
		System.out.println("세 번째 문자:"+a.charAt(2));
		System.out.println("입력된 글자 갯수:"+a.length());
		
	}
}
