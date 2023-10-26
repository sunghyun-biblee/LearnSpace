package com.chap02_StringBuffer_StringBuilder.run;

public class Run {

	public static void main(String[] args) {
//		StringBuffer 와 StringBuilder는 메소드가 동일
		
		StringBuilder sb=new StringBuilder("우리는");
		System.out.println(sb);
		System.out.println(sb.length());
		sb.append(" 성공할 것이다 ").append("머지않아");
		System.out.println(sb);
		System.out.println(sb.length());
		
		sb.insert(0, "밥을 먹고 난 후 "); //문자열 0번자리에 insert(추가) 하겠다
		System.out.println(sb);
		sb.delete(0, 10);  // 문자열 0번 부터 10번전까지(9번까지) 문자열을 delete(삭제) 하겠다
		System.out.println(sb);
		sb.reverse();  // 문자열을 반대로 출력한다.
		System.out.println(sb);
	}

}
