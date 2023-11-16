package com.edu.entity;

public class Rectangle extends Shape {

	public Rectangle() {
		super();
	}
	public Rectangle(String title,int width, int height) {
		super(title,width,height);
	}
	
	
	@Override
	public void viewSize() {
		System.out.println(super.getTitle()+"의 넓이: "+(super.getWidth()*super.getHeight()));
	}
}
