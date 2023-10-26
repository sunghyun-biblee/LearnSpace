package com.chap02_throw.run;

import java.io.IOException;

public class Run {

	public static void main(String[] args) /* throws IOException */ { // 마지막 main은 예외를 jvm으로 던져준다.
		try {
			methodA();
		}catch(IOException e) {
			System.out.println("main()에서 처리");
		}
	}

	public static void methodA() throws IOException {
		methodB();
	}

	public static void methodB() throws IOException {
		methodC();
	}

	public static void methodC() throws IOException {
		throw new IOException();
	}
}
