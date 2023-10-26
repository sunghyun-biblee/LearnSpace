package com.chap01_String.run;

public class Run {
	
//	apu : application Programming Interface / 응용프로그램 프로그래밍 인터페이스
//			운영체제나 프로그래밍 언어가 제공하는 기능을 제어할 수 있게 만든 인터페이스
//			자바를 사용하면서 코딩을 쉽게 할 수 있도록 기능등을 만들어 놓은 것
	public static void main(String[] args) {
//		Run.method01();
		Run.method02();
	}
	
	public static void method01() {
//		String 클래스
		
//		1. 문자열을 리터럴로
		String str1="abc";
		String str2="abc";
		
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		//String class에서 오버라이딩된 hashCode()가 아닌 객체별 고유 hashCode를 출력
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
//		싱글톤 : 생성자가 여러 차례 호출되더라도 실제로 생성되는 객체는 하나이고 
//		   최초 생성 이후에 호출된 생성자는 최초의 생성자가 생성한 객체를 리턴한다
		
		
		
		// 2. 생성자를 통한 문자열 생성
		String str3 = new String("abc"); // new생성자를 사용하여 새로운 공간을 만들어 생성
		String str4 = new String("abc"); // string pool 영역을 사용한다. 

		
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
	}
	
	public static void method02() {
		String str="오후 수업 시작! ";
		System.out.println("str : "+str + ", 주소 : "+ System.identityHashCode(str));
		
		str+="화이팅! ";
		System.out.println("str 추가후 : "+str + ", 주소 : "+ System.identityHashCode(str));
		
		
		///
		// String Buffer , StringBuilder
		StringBuffer sbf=new StringBuffer("4교시에요! ");
		System.out.println("sbf: "+sbf+" , 주소 : "+System.identityHashCode(sbf));
		System.out.println("sbf: "+sbf.hashCode());
		
//		sbf+="잠이 오면...	"; // StringBuffer, StringBuilder는 연산자를 사용하여 값을 초기화 할 수 없다.
		sbf.append("잠이 오면...");
		System.out.println("sbf 추가후 : "+ sbf+ ", 주소 : "+System.identityHashCode(sbf));
	}
	
	
	
	
	
	
	
	
	
	
}
