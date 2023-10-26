package com.chap04_wrapperClass.run;

public class Run {
	/*
	 * WrapperClass - 프로그램에 따라 기본타입의 데이터를 객체로 취급해야 하는 경우가 있다. 기본타입의 데이터를 그대로 사용할 수
	 * 없기에 객체로 변환 후 작업을 수행해야 한다. 8개의 기본타입에 해당하는 객체로 포장해주는 클래스가 WrapperClass이다.
	 * 
	 * Boxing : 기본 자료형을 Wrapper 클래스 객체로 변경 (AutoBoxing : 자동처리)
	 * UnBoxing : Wrapper클래스 > 기본자료형으로 변경 (AutoUnBoxing : 자동처리)
	 * 
	 */
	public static void main(String[] args) {
//		Boxing
		Integer i = new Integer(12);
		Integer i2 = new Integer(11);
		Double d = new Double(10.1);

		System.out.println(i == i2);
		System.out.println(i.equals(i2));
		System.out.println(i.compareTo(i2));
		// i<i2 => -1 (음수)
		// i>i2 => 1 (양수)
		// i==i2 => 0
		// 숫자와 문자를 비교 가능

		// AutoBoxing
		Short i3 = 10;
		Integer i4 = 5;
		Double d2 = 5.0;

		// UnBoxing
		// Wrapper 클래스를 기본자료형으로
		int a = i4.intValue();
		double b = d2.doubleValue();

		// AutoUnBoxing
		int a2 = i4;
		double b2 = d2;
		System.out.println(a2 + b2);
		abox(a2); // int >>(AutoBoxing)>> Integer >>(다형성 적용)>> Object

	}

	public static void abox(Object obj) {
		System.out.println(obj);

	}

}
