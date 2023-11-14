package com.test05;

public class LgTV implements TV{

	
	
	public LgTV() {
		System.out.println("lg tv 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("lg tv on");
	}

	@Override
	public void powerOff() {
		System.out.println("lg tv off");
	}

}
