package com.arrayPractice1.sample;

import java.util.Random;
import java.util.Scanner;

public class ArraySample {
	public static void main(String[] args) {
		ArraySample as = new ArraySample();
//		as.test1();
//		as.test2();
//		as.test3();
//		as.test4();
		as.test5();
	}

	public void test1() {
		int sum = 0;
		int arr[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(100) + 1;
			System.out.print(arr[i] + "!!");
			sum += arr[i];
			System.out.println(sum);
		}
	}

	public void test2() {

		int min = 0;
		int max = 0;
		Random rd = new Random();
		int arr[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(100) + 1;
			System.out.println(arr[i] + "!!");
			if (min == 0 || max == 0) {
				if (min == 0) {
					min = arr[i];
				} else if (max == 0) {
					max = arr[i];
				}

			} else if (arr[i] < min) {
				min = arr[i];
			} else if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.print("가장 작은값" + min + " : 가장 큰 값 : " + max);
	}

	public void test3() {
		byte arr[] = new byte[10];
		int sum = 0;
		Random rd = new Random();
		for (int i = 0; i < arr.length; i++) {
			rd.nextBytes(arr);
			System.out.println(arr[i]);
			if (arr[i] > 0) {
				if (arr[i] % 2 == 0) {
					sum += arr[i];
				}
			}
		}
		System.out.println("짝수들의 총합 : " + sum);
	}

	public void test4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력");
		String str = sc.next();

//		01
//		12
//		23
//		34
//		45
//		56
		int sum = 0;
		for (int i = 0, j = 1; i < str.length(); i++, j++) {
			sum += Integer.parseInt(str.substring(i, j));

		}
		System.out.println(sum);

	}

	public void test5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력");
		String str = sc.next();

		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			int A = (str.charAt(i));
			sum += A - '0';
			
		}System.out.println(sum);
	}

}
