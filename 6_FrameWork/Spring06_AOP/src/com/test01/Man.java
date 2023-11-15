package com.test01;

public class Man {
	public void classWork() {
		System.out.println("qr 코드를 찍는다.");
		
		try {
			System.out.println("컴퓨터를 켜서 MLP에 로그인한다");	
		} catch (Exception e) {
			System.out.println("주말이었다.");
		} finally {
			System.out.println("침대에 눕는다.");
		}
		
	}
}
