package com.poly.test02;

//interface 상속은 implements 키워드 사용
//extends 키워드는 단일 상속 지원.
//implements 키워드는 다중 상속도 지원
public class Cat implements Animal {
	@Override
	public void bark() {
		System.out.println("냐용");
	}

	@Override
	public void eat(String feed) {
		System.out.println("고양이가 " + feed + " 먹는다!");
	}
}
