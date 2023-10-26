package com.test;

public class Variable01 {
	
	// main method : 메인메소드, 프로그램의 진입점, 프로그램실행하는 기능
	public static void main(String[] args)	{
		Variable01 var = new Variable01();
		var.test01();
		var.test02();
		
		
	}
	// [변수 선언] -> 방 만 만드는 것
	// 자료형(타입) 변수명 ;
	// 자료형: 생성할 변수에 종류(어떠한 종류의 값이 들어갈지 타입을 지정)
	// 변수명: 변수의 이름 (방의 이름), 우리가 사용할 변수의 이름을 지정
	
	// 기능 메소드 
	public void test01() {
		// 숫자
		// 정수
		byte bnum;
		short snum;
		int inum;
		long lnum;
		// 실수
		float fnum;
		double dnum;
		
		// 논리 (참 아니면 거짓만) 
		boolean isTrue;
		
		// 문자 (a,b,c,가,나,다.....)
		char ch;
		
		// 문자열(참조형, 참조하기위해 사용하거나 or 사용할때는 기본형 처럼 사용 가능)
		String str;
		
		// 변수에 값 대입
		bnum=1;
		snum=3;
		inum=10;	
		lnum=100L; // L을 붙이지 않아도 자동형변환으로 long으로 변환.
		
		fnum=0.13f; // float은 자동형변환이 되지않으니 f를 무조건 작성해야한다. 
		dnum=8.01;
		
		isTrue=false; // JAVA에서는 무조건 true or false로 작성해야한다.
		
		ch='s';
		str="sunghyun";
		
		//변수에 저장된 값을 출력하기 (출력문)
		System.out.println("bnum : "+bnum);
		System.out.println("snum : "+snum);
		System.out.println("inum : "+inum);
		System.out.println("lnum : "+lnum);
		System.out.println("fnum : "+fnum);
		System.out.println("dnum : "+dnum);
		System.out.println("isTrue : "+isTrue);
		System.out.println("ch : "+ch);
		System.out.println("str : "+str);
		System.out.println("내 이름은:"+str);
		System.out.println("내 나이는:"+inum);
		System.out.println("내 키는:"+lnum);
		
		
	}
	
	//[변수 선언과 동시에 초기화]
	public void test02() {
		int age=25;
		float weight=67.5f;
		String name="sunghyun";
		
		//변수에 저장된 값 출력
		System.out.println("나의 나이는 : "+ age);
		System.out.println("나의 몸무게는 : "+ weight+"kg");
		System.out.println("나의 이름은 : "+ name);
		
	}
	
}
