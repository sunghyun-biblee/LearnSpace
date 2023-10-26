package com.poly.test03;

public abstract class Animal {
	public abstract void bark();
	public void eat(String animal) {
		System.out.println(animal+" 먹는다");
	}
}
