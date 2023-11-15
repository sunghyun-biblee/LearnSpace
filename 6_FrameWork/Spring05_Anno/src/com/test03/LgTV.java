package com.test03;

import org.springframework.stereotype.Component;

@Component("LG")
public class LgTV {

	public void powerOn() {
		System.out.println("lg tv power on");
	}
	public void powerOff() {
		System.out.println("lg tv power off");
	}
}
