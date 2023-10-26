package com.test01;

public class Thread02 {

	public static void main(String[] args) {
		MyThread3 m1 = new MyThread3("야옹");
		MyThread3 m2 = new MyThread3("멍멍");
		
//		java의 thread scheduling
//		우선순위(priority)와
//		순환할당(round-robin) - jvm에 의해 결정되기 때문에 개발자의 임의로 수정 불가
		
		m1.setPriority(10);
		m2.setPriority(1);
		
		m1.start();
		m2.start();
	}

}

class MyThread3 extends Thread {

	public MyThread3(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 500; i++) {
			System.out.println(this.getName() + "=" + i);
		}
		System.out.println(this.getName() + "종료");
	}
}