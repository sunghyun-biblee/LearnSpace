package com.test01;

public class MTest {

	public static void main(String[] args) {
		Woman w = new Woman();
		Man m = new Man();
		
		
		System.out.println("여학생 입장: ");
		w.classWork();
		System.out.println("-------------");
		System.out.println("남학생 기상");
		m.classWork();
	}

}


// w , m 클래스에 공통코드 > ccc 공통관점
// > 핵심기능 cc 


/*
>> CC (핵심기능)
System.out.println("컴퓨터를 켜서 MLP에 로그인한다");	

---------------------------------------------------
>> CCC 공통관점
System.out.println("qr코드를 찍는다.");
System.out.println("주말이었다."); 

System.out.println("침대에 눕는다.");
*/