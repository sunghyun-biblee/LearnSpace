package com.test01;

public class Thread03 {
	public static void main(String[] args) {
		MyThread3 m1 = new MyThread3("야옹");
		MyThread3 m2 = new MyThread3("멍멍");

		long start_time = System.currentTimeMillis();

		m1.start();
		try {
			m1.join(); // m1 thread가 종료될 때 까지 다른 thread를 멈춘다
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end_time = System.currentTimeMillis();

		m2.start();

		System.out.println("실행시간 : " + (end_time - start_time));
	}
}
