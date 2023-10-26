package com.poly.silsub1.shape.model.vo;

public class Rectangle extends Shape{
	// 필드
	private double width;
	private double height;
	
	//생성자
	
	public Rectangle() {
		
	}
	
	public Rectangle(double width, double height) { // 가로,세로 값 초기화 생성자
		this.width=width;
		this.height=height;
		
	}

	//getter & setter
	public double getWidth() {
		return this.width;
	}
	
	public void setWidth(double width) {
		this.width=width;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public void setHeight(double height) {
		this.height=height;
	}
	
	@Override
	public void area() {
		double a= getWidth();
		double b= getHeight();
		int res=(int)(a*b);
		System.out.println(res);
	}

	@Override
	public void perimeter() {
		
	
	}
}
