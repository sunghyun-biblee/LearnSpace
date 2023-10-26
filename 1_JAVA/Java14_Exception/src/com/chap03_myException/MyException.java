package com.chap03_myException;

public class MyException extends Exception { //Exception 상속받아 예외클래스로 선언
	// 기본생성자
	public MyException() {
		
	}
	
	//매개변수 생성자
	public MyException(String msg) {
		super(msg);
	}
}
