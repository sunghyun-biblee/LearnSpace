package com.test02;

import com.test01.Method01;

public class Method03 /*extends Method01*/ {
	public static void main(String[] args) {
//		Method 호출 방법 ( 실행 방법 )
//		1. static : 클래스명. 메소드명()	;
		
		Method01.publicMethod();
		 
//		 자바에서는 클래스를 상속받을수 있는건 하나만 받을 수 있다.
//		 Method01.protectedMethod(); : 같은 패키지내에 존재하지않기 때문에 접근 불가능 + 상속 안됨
//		 							   상속은 클래스명뒤에 extends 클래스명 작성해주어야함
		 
//		 Method01.privateMethod(); : 같은 클래스내에 존재하지않기 때문에 접근 불가능
//		 Method01.defaultMethod(); : 같은 패키지내에 존재하지않기 때문에 접근 불가능
		 
		
//		2. non static :
//		(1) 준비 : 클래스명 변수명 = new 클래스명();
//		(2) 실행 : 변수명.메소드명();
		
		
// 		non static 메소드를 public으로 지정해두었기때문에 어디서든 호출 가능하다.		
		Method01 mt = new Method01(); 
		mt.NonstaticMethod();
		
	 }
}
