package com.test01;

public class Method01 {
	public static void main(String[] args) {
	 	// Static : 실행(Run) 누르는 순간 시작
		
		// static method 실행 
		// 클래스명.메소드명(); => static이 붙은 메소드 실행방법
		Method01 var = new Method01();
		
		Method01.publicMethod();
		Method01.protectedMethod();
		defaultMethod();
		privateMethod();
	}
	
	// 접근제한자
	// public (+) : (공공의) 누구나 어디서나 접근,참조 가능하다.  
	public static void publicMethod() {
		System.out.println("public Method");
	}
	
	// protected (#) : 상속일 경우 상속된 곳에서, 상속이 아닌 경우 같은 패키지 안에서만 접근가능 
	protected static void protectedMethod() {
		System.out.println("protected Method");
	}
	
	//default (default) : 같은 패키지 안에서만 접근 가능 
	static void defaultMethod() {
		System.out.println("default Method");
	}
	
	//private (-) : 현재 클래스안에서만 접근 가능
	private static void privateMethod() {
		System.out.println("private Method");
	}
	
	//non static method
	public void NonstaticMethod() {
		System.out.println("Nonstatic Method");
	}
	
}
