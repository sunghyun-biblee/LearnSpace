package com.silsub2.point.main;

import com.silsub2.point.model.vo.Circle;
import com.silsub2.point.model.vo.Rectangle;

public class Main {

	public static void main(String[] args) {
		Circle ci=new Circle(3,3,3+3/2);
		ci.draw();
		
		Circle[] c=new Circle[3];
		Rectangle[] r=new Rectangle[3];
		
		c[0]=new Circle(10,10,1);
		c[1]=new Circle(20,20,50);
		c[2]=new Circle(30,30,100);
		
		
		r[0]=new Rectangle(10,10,10,30);
		r[1]=new Rectangle(20,20,20,40);
		r[2]=new Rectangle(30,5,50,20);
		for(int i=0; i<c.length;i++) {
			c[i].draw();
		}
		for(int i=0;i<r.length;i++) {
			r[i].draw();
		}
	}

}
