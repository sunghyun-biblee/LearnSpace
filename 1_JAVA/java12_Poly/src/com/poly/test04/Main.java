package com.poly.test04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("도형을 선택 해주세요 [1:원 2:삼각형 3.사각형] : ");
		int no = sc.nextInt();
		
		
		Area ar = null;

		switch (no) {
		case 1:
			ar = new Circle();
			break;
		case 2:
			ar = new Triangle();
			break;
		case 3:
			ar = new Square();
			break;
		}

		ar.make();
		ar.print();
	}

}
