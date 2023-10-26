package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Variable02 {
	// 키보드 입력하는 값을 통해서 출력해보기
	// java.io 패키지에서 제공되는 클래스 활용
	public static void main(String[] args) {
		
		Variable02 var = new Variable02(); //준비과정
		//var.inputTest01();
		var.inputTest02();
	}
	
	public void inputTest01() {
		// 현재 위치한(com.test) 패키지외 다른 패키지에 속한 클래스를 사용할 때 import 해줘야 한다.
		// import는 패키지 바로 밑에 작성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String value = br.readLine();
			String value02=value+"!!";
			System.out.println(value02);
		} catch(java.io.IOException e) {
			e.printStackTrace();
		}
	}
	
	public void inputTest02() {
		//java.util.Scanner
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);
		
		System.out.println("회의 번호를 입력하세요 :");
		System.out.println("이름을 입력하세요 :");
		System.out.println("몸무게를 입력하세요 :");
		System.out.println("남자인가요 :");
		
		int number = sc.nextInt();
		String name = sc2.nextLine();
		double weight = sc3.nextDouble();
		boolean isTrue = sc4.nextBoolean();
		
		System.out.println("회의번호는:"+ number);
		System.out.println("이름은:"+ name);
		System.out.println("몸무게는:"+ weight);
		System.out.println("남자인가요?:"+ isTrue);
	}
	
}

// 변수가 뭔지만 기억하자
// 강사님이 기억하라는 것만 기억하면 된다