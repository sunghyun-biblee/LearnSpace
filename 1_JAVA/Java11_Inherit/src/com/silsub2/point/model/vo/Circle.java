package com.silsub2.point.model.vo;

public class Circle extends Point {
	private int radius;

	public Circle() {
	}

	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = (x + y) / 2;
	}

	@Override
	public void draw() {

//		System.out.println("원의 x좌표 :"+x+"\n원의 y좌표 :"+y);
		super.draw();
		double res = Math.PI * radius * radius;
		double circum = 2 * radius * Math.PI;
		System.out.printf("원의 면적은 : %.1f",res);
//		=>(int)((radius*radius*Math.PI)*10)/10.0  ||  Math.round((radius*radius*Math.Pi)*10)/10.0);
		System.out.println();
		System.out.printf("원의 둘레는 : %.1f",circum);
//		=> (int)((radius*2*Math.PI)*10)/10.0  

	}
}
