package com.chap03_StringTokenizer.run;

import java.util.StringTokenizer;

public class Run {
/*
 *  StringTokenizer
 * 	split()과 큰 차이점 : split은 String 클래스의 메소드로 추출한 문자를 배열로 저장.
 * 					   StringTokenizer는 클래스로 추출한 문자를 토큰으로 저장.
 * 
 * 	countToken : 토큰 수 파악
 * 	nextToken : 토큰 읽어오기
 * 	hasMoreTokens : 토큰이 남아 있는지 확인, 후 nextToken으로 토큰 읽어옴
 */
	public static void main(String[] args) {
		String str = "조성현,25,대구 남구,남";
		StringTokenizer st=new StringTokenizer(str,",");
		System.out.println(st.countTokens());
		
		while(st.hasMoreTokens()) { // 토큰이 남아있는지 확인
			System.out.println(st.nextToken());  // 토큰이 남아 있다면 토큰을 읽어옴
		}
		
		///
		
		System.out.println();
		String arr[]=str.split(",");
		for(String res:arr) { // res 객체 생성 => 반복수는 arr의 배열길이값만큼 =>값은 arr배열값으로 초기화
			System.out.println(res);
		}
	}

}
