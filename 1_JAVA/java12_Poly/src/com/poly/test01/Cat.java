package com.poly.test01;

public class Cat extends Animal {
	@Override
	public void bark() {
		System.out.println("냐용");
	}
	@Override
	public void eat(String animal) {
		System.out.print("고양이가 ");
		super.eat(animal);
	}
}
