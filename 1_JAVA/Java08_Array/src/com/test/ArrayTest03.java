package com.test;

public class ArrayTest03 {
	public static void main(String[] args) {
//		static 메소드 실행 ( 클래스명.메소드명 )

		// 배열에 데이터 입력
		char ch[] = new char[26];
		for (int i = 0; i < 26; i++) {
			ch[i] = (char) ((int) 'a' + i);
		}

//		1. a~z 일차원 배열 출력
//		prn(ch);
//		2. 만든 배열(Ch)을 거꾸로 출력
//		reverse(ch);
		upper(ch);
//		3. 만든 배열(ch)를 대문자로 변경

	}

	public static void prn(char ch[]) {
//		1.
		for (int i = 0; i < ch.length; i++) {

			System.out.println(ch[i]);
		}
	}

	public static void reverse(char ch[]) {
//		2.
		for (int i = ch.length-1; i >= 0; i--) {
			System.out.print(ch[i]);
		}
	}

	public static void upper(char ch[]) {
//		3. -32
		for(int i= 0; i<ch.length;i++) {
			int B=(int)(ch[i]-32);
			char C=(char)(B);

			System.out.println(C);
		}
	}
}
