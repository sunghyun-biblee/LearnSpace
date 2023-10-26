package com.poly.test01;

public abstract class Animal {

//	추상 메소드 -> 상속받은 class가 반드시 구현해야 한다.
	public abstract void bark();

	public void eat(String animal) {
		System.out.println(animal + "먹는다.");
	}

}
