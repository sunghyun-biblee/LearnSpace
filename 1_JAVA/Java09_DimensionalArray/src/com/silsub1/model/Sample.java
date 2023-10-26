package com.silsub1.model;

import java.util.Scanner;

public class Sample {
	public static void main(String[] args) {
		Sample sm = new Sample();
//		sm.munjae1();
		sm.munjae2();
	}

	public void munjae1() {
		int arr[][];
		int tsum = 0;
		int 가로sum1 = 0;
		int 가로sum2 = 0;
		int 가로sum3 = 0;
		int 세로sum1 = 0;
		int 세로sum2 = 0;
		int 세로sum3 = 0;
		int 세로;
		int 가로;
		arr = new int[4][4];

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				int rn = (int) (Math.random() * 100) + 1;
				arr[i][j] = rn;
				System.out.print("\t" + arr[i][j]);
			}
			System.out.println();
		}

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr[i].length - 1; j++) {

				switch (i) {
				case 0:
					가로sum1 += arr[i][j];
					break;
				case 1:
					가로sum2 += arr[i][j];
					break;
				case 2:
					가로sum3 += arr[i][j];
					break;
				}

			}
		}
		System.out.println("가로sum1:" + 가로sum1 + " 가로sum2:" + 가로sum2 + " 가로sum3:" + 가로sum3);
		for (int i = 0; i < arr[i].length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				switch (j) {
				case 0:
					세로sum1 += arr[i][j];
					break;
				case 1:
					세로sum2 += arr[i][j];
					break;
				case 2:
					세로sum3 += arr[i][j];
					break;
				}

			}

		}
		세로 = 세로sum1 + 세로sum2 + 세로sum3;
		가로 = 가로sum1 + 가로sum2 + 가로sum3;
		System.out.println("세로sum1:" + 세로sum1 + " 세로sum2:" + 세로sum2 + " 세로sum3:" + 세로sum3);
		System.out.println("가로 세로의 합계 : " + (가로 + 세로));
	}

	public void munjae2() {

		int sum = 0;
		Scanner sc = new Scanner(System.in);
//		arr[i][j] => i는 가로,행 (row) j는 세로,열 (column)
		int arr[][];
		arr = new int[3][];
		System.out.println("0행의 열갯수를 입력하세요 ");
		arr[0] = new int[sc.nextInt()];
		System.out.println("1행의 열갯수를 입력하세요 ");
		arr[1] = new int[sc.nextInt()];
		System.out.println("2행의 열갯수를 입력하세요 ");
		arr[2] = new int[sc.nextInt()];

//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(" 열갯수를 입력해주세요");
//			arr[i] = new int[sc.nextInt()];
//		}
//		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				int rn = (int) (Math.random() * 100) + 1;
				arr[i][j] = rn;
				System.out.print("\t" + arr[i][j]);
			}
			System.out.println();
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
				
			}
			if (sum % 5 == 0) {
				System.out.println(i + " 행의 열별합은 : " + sum);
				sum = 0;
			} else {
				sum = 0;
			}
			
		}

	}
}
