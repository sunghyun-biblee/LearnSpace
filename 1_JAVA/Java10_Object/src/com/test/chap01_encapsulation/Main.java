package com.test.chap01_encapsulation;

public class Main {
	public static void main(String[] args) {
		//객체 생성
		Account a=new Account();
		Account b=new Account();
		
		//현재 잔액조회
		a.prnBalance();
		
		//입금
		a.in(10000);
		a.prnBalance();
		
		a.in(15000);
		a.prnBalance();
		
		//출금
		a.out(5000);
		a.prnBalance();
		
		//
		b.prnBalance();
		//
		
//		a.balance-=15000; //필드 접근제한을 하지않으면 balance에 접근 가능
//		private으로 접근을 제한 하였기때문에 더이상 접근 불가능
		
		a.out(15000);
		a.prnBalance();
	}
}
