package com.inherit.test01;

public class SUV extends Car {
	
	private String brand;

	public SUV() {
		System.out.println("SUV 생성");
	}

	public SUV(String color) {
		super(color);
		System.out.println(color + "색 SUV 생성 ");
	}

	public SUV(String color, String brand) {
		super(color);
		this.brand = brand;
		System.out.println(color + " 색 " + brand + " SUV 생성");
	}

	@Override
	public void accelPedal() {
		System.out.println("속도가 적당히 올라갑니다");
		setSpeed(getSpeed() + 5);
	}

	@Override
	public void breakPedal() {
		if (super.getSpeed() > 0) {
			System.out.println("속도가 적당히 내려갑니다");
		} else {
			System.out.println("차량이 멈췄습니다");
			super.setSpeed(0);
		}
	}

	@Override
	public String toString() {
		return brand + " SUV의 현재 속도는 " + super.getSpeed() + "입니다.";
	}
}
