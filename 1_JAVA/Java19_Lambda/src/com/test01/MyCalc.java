package com.test01;


//FunctionalInterface가 언급되어 있다면 하나의 추상메소드가 꼭 있어야한다

@FunctionalInterface 
public interface MyCalc {
	double calc(double a, double b);
}
