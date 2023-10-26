package com.inherit.test01;

public class SportsCar extends Car { //extends => 상속하다
	
	// 기본생성자
	public SportsCar() {
//		super();  => 모든 생성자에는 super(); 생략된채 실행 (jvm이 생략처리) / 생성자 호출 시 부모생성자 호출부터 된다. (=안젹혀있더라도)
		System.out.println("SportsCar 생성");
		
	}
	
	//매개변수 생성자
	public SportsCar(String color) {
		super(color); //부모 매개변수 호출 => 상속받은 매개변수 호출
		System.out.println(color+"색 SportsCar 생성 ");
	} 
}
