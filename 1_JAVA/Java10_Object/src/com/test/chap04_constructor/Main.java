package com.test.chap04_constructor;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		User u1 = new User(); // 기본생성자를 이용하여 객체 생성
		u1.information();

		User u2 = new User("user01", "pass01", "name");
		u2.information();

		User u3 = new User("user02", "pass02", "name2", new Date());
		u3.information();
		// 매개변수 생성자를 이용하여 객체 생성!
		// 아래의 생성자를 이용하여 객체가 생성될 수 있도록 생성자 추가!
		// 실행 하였을때 매개변수로 넘겨 준 값들로 초기화 되는 모습 확인!

	}

}
