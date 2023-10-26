package com.silsub2.point.model.vo;

public class Point {
	//필드
	protected int x;
	protected int y;
	
	//생성자
	public Point() {}
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	
	//getter && setter && draw()
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	
	public void draw() {
		System.out.println("x의 좌표값은 : "+ x);
		System.out.println("y의 좌표값은 : "+ y);
	}
	
	
	
}
