package com.inherit.test02;

public class Main {
	public static void main(String[] args) {
		Book b1=new Book("이것이 자바다","멀티",100);
		Book b2=new Book("이것이 DB다","캠퍼스",300);
		
//		두 객체의 정보 출력 처리 : toString();
//		System.out.println(b1.toString());
//		System.out.println(b2.toString());
		
//		.toString은 객체 호출시 자동으로 뒤에 jvm에 의해 생성
//		==> 따라서 객체의 값 확인을 위해 오버라이딩해서 많이 사용함
		System.out.println(b1);
		System.out.println(b2);
		System.out.println("b1과 b2는 같은 객체인가? : "+b1.equals(b2));
		
//		얕은복사
		Book b3=b1;
		System.out.println("b1==b3 ? "+ b1.equals(b3));
		
		
//		깊은복사
//		해쉬코드는 서로 다르지만 b1과 b4는 값이 같기 떄문에 같은 객체로 취급하려 한다면
//		equals()를 오버라이딩하자
		Book b4=new Book("이것이 자바다","멀티",100);
		System.out.println("b1==b4 ? "+ b1.equals(b4));
		
//		안에 들어있는 값까지 같으면 해쉬코드까지 똑같아 진다.
		System.out.println(b1.hashCode());
		System.out.println(b4.hashCode());
	}
}
