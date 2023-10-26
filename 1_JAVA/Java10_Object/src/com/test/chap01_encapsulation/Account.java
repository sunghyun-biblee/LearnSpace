package com.test.chap01_encapsulation;

public class Account {
//	필드(멤버변수)
//	private => 접근제한을 두면서 캡슐화
	private String name = "조성현";
	private String accNo = "01012345678";
	private String pwd = "1234";
	private int bankcode = 20;
	private int balance = 0;

//	메소드(멤버함수)

//	생성자(객체를 생성하기 위한 메소드)
	public Account() {
	}

//	입금을 위한 메소드
	public void in(int money) {
		if(money>0) {
			balance+=money;
			System.out.println(name+"님의 계좌에 "+money+"원이 입금되었습니다");
		}else {
			System.out.println("입금금액을 1원 이상 입력해주세요");
		}
	}

//	출금을 위한 메소드
	public void out(int money) {
		if(money<balance) {
			balance-=money;
			System.out.println(name+"님의 계좌에서 "+money+"원이 출금되었습니다");
		}else {
			System.out.println("계좌 잔액이 부족합니다.");
		}
	}

//	잔액조회를 위한 메소드
	public void prnBalance() {
		System.out.println(name+"님의 계좌의 잔액은 "+balance+"원 입니다");
	}

}
