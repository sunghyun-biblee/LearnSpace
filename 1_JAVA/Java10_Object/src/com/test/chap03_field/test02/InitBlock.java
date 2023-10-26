package com.test.chap03_field.test02;

public class InitBlock {
	
//	1. 지정된 기본값으로 초기화
//	private String pName;
//	private int price;
//	private static String brand;
	
	
//	2. 정적으로 기본값 초기화
	private String pName="갤럭시 s23";
	private int price=1200000;
	private static String brand="삼성";
	

	public void information() {
		// 외부에서 접근이 불가능 필드 (private로 선언)에 저장된 데이터 확인용 메소드
		System.out.println(pName + "," + price + "," + brand);
	}

	
//	3. 초기화 블럭
//	static 초기화 블럭
//  순서 : start -> Main 실행 -> 객체 생성
	static {
//		 static 초기화블럭에서는 non static 필드 초기화 할 수 없다.
//		pName="아이폰15";
//		price=1500000;
		brand="애플";
	}
//	 인스턴스 초기화 블럭
	{
//		 인스턴스 초기화블러게서는 static 필드 초기화 가능
		pName="아이폰";
		price=150000;
		brand="apple";
	}
	
	
	// 4. 매개변수 있는 생성자
	public InitBlock() {}  // 기본 생성자
	
	public InitBlock(String pName, int price, String brand) {
		// 매개변수 생성자
		// 전달받은 값으로 초기화
		this.pName=pName;	// non-static 필드이기에 해당 객체를 의미함
		this.price=price;	// this 키워드로 필드에 접근
		InitBlock.brand=brand; // static 필드이기에 클래스명으로 접근
	} 
 	
	
	
	
}
