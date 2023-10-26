package com.poly.test03;

public class Cat extends Animal{
@Override
public void bark(){
	System.out.println("냐용");
}

@Override
public void eat(String feed) {
	System.out.println("공양잉는 "+ feed + " 먹는다");
}
}
