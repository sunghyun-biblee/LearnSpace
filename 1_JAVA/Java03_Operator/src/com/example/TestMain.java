package com.example;

import java.util.Scanner;
public class TestMain extends Example {
	public static void main(String[] args) {
		TestMain tm=new TestMain();
		tm.example01();
		tm.example02();
		tm.example03();
		
//		준비과정 + 실행과정 단축방법
		new  Example().example01();
		new  Example().example02();
		new  Example().example03();
		
		
	}
}
