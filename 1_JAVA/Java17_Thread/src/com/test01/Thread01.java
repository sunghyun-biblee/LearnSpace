package com.test01;

public class Thread01 {

	public static void main(String[] args) {
		System.out.println("===== main start=====");

//		thread로 실행하는 것이 아닌 run() 메소드를 실행한 것
//		MyThread m1 = new MyThread();
//		MyThread m2 = new MyThread();
//		m1.run();
//		m2.run();
		
		Thread m1= new Thread(new MyThread());
//		thread.start() -> 자동으로 run() 호출
		m1.start();
		
		Thread m2= new Thread(new MyThread());
		m2.start();
		
		System.out.println("===== main stop =====");
	}
}

class MyThread implements Runnable {
	@Override
	public void run() {
		// 실행할 코드 작성
		for (int i = 0; i < 300; i++) {
			System.out.println("i = " + i);

		}
	}
}
