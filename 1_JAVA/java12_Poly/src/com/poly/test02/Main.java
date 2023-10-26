package com.poly.test02;

public class Main {

	public static void main(String[] args) {
		Animal ani=new Cat();
		ani.bark();
		ani.eat("생선");

		
		ani=new Dog();
		ani.bark();
		ani.eat("사료");
	}

}
