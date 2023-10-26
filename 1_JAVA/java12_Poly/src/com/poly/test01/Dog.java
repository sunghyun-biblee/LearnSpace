package com.poly.test01;

public class Dog extends Animal {
	@Override
	public void bark() {
		System.out.println("왕왕");
	}

	@Override
	public void eat(String animal) {
		System.out.print("강아지가 ");
		super.eat(animal);
	}
}
