package com.test.chap04_constructor;

import java.util.Date;

public class User {

	private String userId;
	private String userPwd;
	private String userName;
	private Date date;
	// 생성자
	// 1. 객체를 생성해 주기 위한 목적
	// 2. 매개변수로 전달받은 값으로 필드를 초기화 할 목적

	// 생성자 사용시 주의할 점.
	// 1. 반드시 클래스명과 동일하게 생성 (대/소문자 구분)
	// 2. 리턴형이 존재하지 않는다 (void, int, char, ... )

	// 기본생성자 : 필드 초기화 역할은 수행하지 못하고 객체만 생성할 때 사용
	public User() {
	}

	// 매개변수가 있는 생성자 : 객체생성과 필드를 초기화하는 두 가지 목적으로 사용
	// 객체를 만들면서 매개변수 안에 있는값으로 초기화를 진행한다.
	public User(String userId, String userPwd, String userName) {
//		this. 숨겨진 채 존재하는 레퍼런스 변수. 할당된 객체 자신을 의미(객체의 주소값)
		
//		지역변수와 필드의 이름이 동일 할 경우 지역변수가 우선시 되기에 
//		필드와 지역변수를 구분하기 위해 this.을 명시해주어야 한다
		this.userId=userId;
		this.userPwd=userPwd;
		this.userName=userName;
		System.out.println(new Date());
	}
	
	public User(String userId, String userPwd, String userName, Date date) {
//		this.userId=userId;
//		this.userPwd=userPwd;
//		this.userName=userName;
		this(userId,userPwd,userName); // 다른 생성자 호출
		
//		 중복되는 동일 한 초기화 하는 내용의 생성자가 존재하는 경우 this()를 이용하여 사용 가능
//		 this() 가장 첫줄에 선언해야 한다.
		this.date=date;
		
		
	}
	

	// 저장도니 필드값 출력용 메소드
	public void information() {
		System.out.println(userId + ", " + userPwd + ", " + userName + ", " + date);
	}

}
