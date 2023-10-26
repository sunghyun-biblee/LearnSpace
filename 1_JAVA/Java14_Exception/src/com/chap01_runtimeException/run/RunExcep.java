package com.chap01_runtimeException.run;



public class RunExcep {
	public static void main(String[] args) {
		RunExcep re = new RunExcep();
//		re.test01();
		re.test02();
	}

	public void test01() {
		// ArithmeticException

//		  예외 발생 
//		  int no1 = 10, no2 = 0; int res = 0; res = no1 / no2;
//		 
//		  System.out.println("res: " + res);

//		해결방안1. if
//		int no1 = 10, no2 = 0;
//		int res = 0;
//		if (no2 == 0) {
//			System.out.println("0입니다. 나눌 수 없습니다");
//		} else {
//			res = no1 / no2;
//
//			System.out.println("res: " + res);

//		해결방안2 try/catch

		int no1 = 10, no2 = 0;
		int res = 0;

		try {
			res = no1 / no2;
			System.out.println("res: " + res);
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticeException 발생");
			System.out.println("0으로 나눌 수 없습니다.");
		}

	}

	public void test02() {
//		ClassCastException : 허용할 수 없는 형변환 연산을 진행하는 경우 발생

//		Object obj='a'; // char>>( Boxing )>>Character>>( 다형성 )>>Object
//		System.out.println(obj);
//		String str= (String)obj;
//		System.out.println(str);

		Object obj = 'a'; // char>>( Boxing )>>Character>>( 다형성 )>>Object
		System.out.println(obj);
		// 1. Character str= (Character)obj;
		// 2.
		if (obj instanceof String) {  // 오브젝트와 string 타입비교
			String str = (String) obj; // 위 주석처리한 코드랑 똑같은데 왜 프린팅이 안되는지 확인하기
			System.out.println("String: " + str);
		} else if (obj instanceof Character) {
			char ch = (Character) obj;
			System.out.println("char: " + ch);
		}
		
		
		
		System.out.println();
		//ArrayIndexOutOfBoundsException
		
		int arr[]=new int[2];
		arr[0]=1;
		arr[1]=2;
		
//		arr[2]=3;  ArrayIndexOutOfBoundsException 발생
		
		for (int i=0; i<3;i++) {
			System.out.println(arr[i]); //ArrayIndexOutOfBoundsException 발생
			// arr길이가 벗어간 값을 출력요구 하였기때문에 발생 즉, arr[2]라는 공간이 없음
		}
		
		
		System.out.println();
//		NullPointerException
		String str=null;
//		int lnegth=str.length(); //NullPointerException 발생
		
		RunExcep r=new RunExcep();
		str=r.res();
		System.err.println("str의 length : "+ str.length());
		
	}
	public String res() {
		return "점심시간이 다가옵니다.";
	}

}
