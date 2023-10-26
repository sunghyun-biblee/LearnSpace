package com.test;

public class ArrayTest01 {

	public static void main(String[] args) {

		ArrayTest01 at = new ArrayTest01();
//		at.testArray();
//		at.testArray2();
		at.testArray3();
	}

	public void testArray() {
		// 배열을 사용하지 않는다면 변수를 여러개 사용해야 한다.
//		int num1=10;
//		int num2=20;
//		int num3=30;
//		int num4=40;
//		int num5=50;

//		int sum=0;

//		sum+=num1;
//		sum+=num2;
//		sum+=num3;
//		sum+=num4;
//		sum+=num5;

		// 배열을 이용
		int arr[] = new int[5];

//		arr[0]=10;
//		arr[1]=20;
//		arr[2]=30;
//		arr[3]=40;
//		arr[4]=50;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i * 10 + 10;
		}
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}

	public void testArray2() {
//		 배열의 선언
//		 자료형 [] 변수명;
//		 자료형 변수명[];

//		 선언은 stack에 배열의 주소를 보관할 수 있는 공간을 생성
//		int[] iarr;
//		char carr[];

//		 주소값을 저장하는 변수 -> 참조형 변수 -> 레퍼런스변수
//		 선언한 레퍼런스변수에 배열을 할당이 가능.
//		 new 연산자는 heap 영역에 공간을 할당하고 발생한 주소값을 반환하는 연산자.

//		 배열을 할당할 때에는 반드시 배열의 크기 지정해 주어야 한다.
//		iarr= new int[]; 		//크기를 지정해 주지 않으면 에러.
//		iarr = new int[5];
//		carr = new char[10];

//		 선언과 할당을 동시에 가능
		int[] iarr = new int[5];
		char carr[] = new char[10];

		System.out.println("iarr: " + iarr);
		System.out.println("carr: " + carr);

//		 hashcode => 실제적인 주소값은 아니지만! 실제주소를 찾기 위한 키(Key) 역할
		System.out.println("iarr의 hashcode : " + iarr.hashCode());
		System.out.println("caar의 hashcode : " + carr.hashCode());

//		 XX.length => (Field)변수
//		 String.length() => 메소드 (괄호가 있고 없고 차이)
//		 괄호가 있으면 메소드 없으면 변수
		System.out.println("iarr의 길이" + iarr.length); // 배열의 길이

		//
		int size = 3;
		double darr[] = new double[size]; // 정수값만 괄호안에 들어가면 문제 없이 생성

		System.out.println("darr의 hashcode : " + darr.hashCode());
		System.out.println("darr의 길이 : " + darr.length);

//		 darr의 크기를 변경
//		 => 배열의 크기를 변경한 것이 아닌, 새로운 배열을 생성하여 주소값을 덮어 쓴것.
//		 한번 지정한 배열의 크기는 변경 불가
		darr = new double[30]; // new double -> 새롭게 double타입을 담을수 있는 배열을 만든 것.

		System.out.println("수정 후 darr의 길이 : " + darr.length);
		System.out.println("수정 후 darr의 hashcode : " + darr.hashCode());

//		 한번 할당된 배열은 지울 수 없다.
//		 다만 변수의 값을 null로 변경하여 더이상 참조하지 않게 만들 수 있다.
//		 null을 사용하여 old 영역을 초기화 한다.
//		  => old: new/young영역에서 저장되었던 객체 중 오래도니 객체가 이동되어 저장되는 영역
		darr = null;

//		NullPointerException 발생 => (null값을 가지고 코드를 실행했을 때)
		System.out.println("삭제 후 darr의 길이 : " + darr.length);

	}

	public void testArray3() {
//		 초기화
//		 heap 영억은 값이 없는 공간이 존재 할 수 없기 때문에
//		 배열을 선언하고 할당을 하면 지정된 기본값으로 배열이 초기화 된다.
		int iarr[] = new int[5];

		iarr[0] = 10;
		iarr[1] = 20;

		for (int i = 0; i < iarr.length; i++) {
			System.out.println(i + ":" + iarr[i]);
		}
		// 중괄호를 이용하여 블럭마다 값을 지정해 주지않아도 된다.
		int iarr2[] = { 11, 22, 33, 44, 55, 66 };
		int iarr3[] = new int[] { 11, 22, 33 };

		System.out.println(iarr2.length + " , " + iarr3.length);

		String sarr[] = { "apple", "banana", "orange", "grape" };
		for (int i = 0; i < sarr.length; i++) {
			System.out.println(sarr.length + ":" + sarr[i]);
		}
		
		
		
		
		
	}

}
