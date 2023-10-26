package com.poly.test04;

import java.util.Scanner;

public class Circle extends AreaImpl {
	@Override
public void make() {
		Scanner sc=new Scanner(System.in);
		System.out.println("반지름 입력 :");
		int r= sc.nextInt();
		
		double res=r*r*Math.PI;
		


		super.setResult(String.format("%.2f", res));
		// 원하는 수를 매개변수로 전달하고싶기 때문에 String.format을 사용하여 문자열형식을 설정한다.
		
	}
	
	
	public void print() {
		System.out.println("원의");
		super.print();
	}
}
