package com.test;

public class Variable04 {
	public static void main(String[] args) {
	Variable04 var = new Variable04();
	//var.test01();
	var.test02();
		
	}
	public void test01(){
		//변수 사이즈 출력
		System.out.println("byte의 크기 :" + Byte.BYTES);
		System.out.println("int의 크기: " + Integer.BYTES);
		System.out.println("double의 크기: "+ Double.BYTES);
		System.out.println("char의 크기: "+ Character.BYTES);
		// BYTES는 각각의 변수로 만들어져있다
		// JAVA에서 제공하는 클래스 안에서 변수가 선언되고 그걸 사용 할 수 있다.
		// JAVA.LANG 패키지만 import를 하지않아도 사용 할 수 있는 패키지이다.
	}
	
	public void test02() {
		//오버플로우
		//byte bnum = 128; 
		// 범위를 벗어난 값을 대입하면 오류가 난다.
		// 계산과정에서 범위를 벗어나면 오버플로우 처리가 된다.
		
		byte bnum = 127;
		byte bnum2 = 127;
		
		//bnum2=(byte)(bnum2+1);  => 오버플로우처리
		bnum2++; // bnum2를 1 증가 시켰다  => 오버플로우처리
		bnum2--; // bnum2를 1 감소 시켰다
		System.out.println("no1? : "+ bnum);
		System.out.print("no2? : "+ bnum2);
	}
	
	
	
	
	
}
