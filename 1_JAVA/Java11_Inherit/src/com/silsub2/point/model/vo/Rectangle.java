package com.silsub2.point.model.vo;

public class Rectangle extends Point {
	private int width;
	private int height;

	public Rectangle() {
	}

	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return x;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return x;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
	public void draw() {
		super.draw();
		System.out.println("사각형의 면적 : "+(int)(width*height)*10/10.0);
		System.out.println(String.format("사각형의 둘레 : %.1f",(width*height)*2.0));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
