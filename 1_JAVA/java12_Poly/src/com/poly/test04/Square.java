package com.poly.test04;

import java.util.Scanner;

public class Square extends AreaImpl {
	@Override
	public void make() {
		Scanner sc = new Scanner(System.in);
		System.out.println("가로를 입력해주세요 : ");
		int x = sc.nextInt();
		System.out.println("세로를 입력해주세요 : ");
		int y = sc.nextInt();
		
		int res=x*y;
		
		super.setResult(String.valueOf(res));
	}
}
