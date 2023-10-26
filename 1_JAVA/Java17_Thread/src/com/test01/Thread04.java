package com.test01;

public class Thread04 {
	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("💨");
		}
	}
}


