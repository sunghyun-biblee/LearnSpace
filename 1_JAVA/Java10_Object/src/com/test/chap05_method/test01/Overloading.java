package com.test.chap05_method.test01;

public class Overloading {
	public int test() {
		return 0;
	}

	public int test(int a) {
		return 0;
	}

	public int test(int a, int b) {
		return 0;
	}

	public int test(int a, String s) {
		return 0;
	}

//	에러발생
//	매개변수명 상관없이 자료형 갯수와 순서가 다르게 작성되어야 한다.
//	public int test(int b, int a) {
//		return 0;
//	}

	public int test(String s, int a) {
		return 0;
	}

	public String test(int a, int b, String str) {
//		return "0";
		return null;
	}

//	에러발생
//	리턴타입이 다르다고 오버로딩이 적용되지 않는다 (=오버로딩에러에 리턴은 포함되지 않는다는걸 알 수 있다)
//	public int test(int a, int b, String str) {
//		return 0;
//	}
	

//	에러발생	
//	접근제한자가 다르다고 오버로딩이 적용되지 않는다.
	
//	private void test(int a, int b, String str) {
//		return 0;
//	}
	
	
	
	
	
	
	
}
