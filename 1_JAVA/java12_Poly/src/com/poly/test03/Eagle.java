package com.poly.test03;

public class Eagle extends Animal implements Bird {
	@Override
	public void fly() {
		// interface bride에 선언되었던 추상메소드 구현
		System.out.println("파닥파닥");
	}
	@Override
	public void bark()	{
		// 추상 클래스 Animal에 선언되었던 추상메소드 구현
		System.out.println("뺚뺚");
	}
	public void eat(String animal)	{
		// 추상 클래스 Animal에 선언되었던 추상메소드 구현
		System.out.println(animal + " 먹는다");
	}
}
