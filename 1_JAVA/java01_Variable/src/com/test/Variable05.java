package com.test;

public class Variable05 {
	// 형변환
	// 자동형변환, 강제형변환
	public static void main(String[] args) {
	Variable05 var = new Variable05();
	var.test01();
		
		
	}
	
	public void test01() {
		// 자료형이 다르더라도 작은 크기의 타입은 큰 크기의 타입으로 저장 가능
		// - 자동형변환,upcasting,묵시적형변환
		// 하지만 큰 크기의 타입은 작은 타입의 크기로 바뀌지 않는다
		// - 강제형변환,casting,명시적형변환
		// 변경할 값(변수) 앞에 (변경할 타입)을 지정해주면 된다
		
		
		int num ='A'; // 문자타입의 값이 int형에 들어간다 ( 자동 형변환 )
		System.out.println("num:" + num); // 65 출력 -> 아스키코드 참조 
		
		char ch=65;   // 정수형 타입의 값이 문자형에 들어간다 ( 자동 형변환 )
		System.out.println("ch: "+ ch); // A 출력 -> 아스키코드 참조
		
		// ch=num;  => type mismatch
		ch = (char)num; // ( 강제 형변환 ) 
		
		long no=65;
		double dno=65;
		
		///
		int inum=10;
		long lnum=100;
		
		// 에러 - type mismatch
		// int isum= inum + lnum ;
		
		//1. 수행 결과를 int로 강제 형변환 -> 두 변수를 계산 후 강제 형변환 
		int isum = (int)(inum+lnum);
		System.out.println("isum:"+ isum);
		
		//2. long타입의 값을 int로 먼저 강제 형변환
		int isum2 = inum + (int)lnum;
		System.out.println("isum2:"+ isum2);
		
		//3. 수행결과를 long타입의 변수에 저장
		long lsum = inum + lnum;
		System.out.println("lsum:" + lsum);
		
		
		
		// 데이터 손실 -> 강제적으로 형변환을 함으로 데이터가 사라짐
		double dnum =1234.56;
		System.out.println("dnum: "+ dnum);
		
		int res = (int)dnum;
		System.out.println("res:" + res);
		
		// 형변환으로 사라진 데이터는 강제 형변환하더라도 다시 돌아오지 않는다
		System.out.println("(double)res:"+(double)res);
		
	}
}
