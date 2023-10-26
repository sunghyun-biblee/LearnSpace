package com.test;

public class ArrayTest02 {

	public static void main(String[] args) {
		ArrayTest02 at = new ArrayTest02();
//		at.shallowCopy();
//		at.deepCopy();
//		at.deepCopy02();
		at.deepCopy03();
	}

	public void shallowCopy() {
//		얕은 복사 : 주소만 복사
		int oriArr[] = { 1, 2, 3, 4, 5 };
		int copyArr[];
		copyArr = oriArr;

		//
		System.out.print("1. oriArr : ");
		for (int i = 0; i < oriArr.length; i++) {
			System.out.print(oriArr[i] + " ");

		}
		System.out.println();
		System.out.print("2. copyArr : ");
		for (int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();
		//

//		 원본 배열의 index 0 의 값을 변경
		oriArr[0] = 99;
		copyArr[3] = 33;
//		접근하는 변수만 다르고 배열 자체는 똑같다 => 동일한 배열을 가르키기 때문에 똑같이 바뀔 수 밖에 없다

//		-------------------
		System.out.print("1. oriArr : ");
		for (int i = 0; i < oriArr.length; i++) {
			System.out.print(oriArr[i] + " ");

		}
		System.out.println();
		System.out.print("2. copyArr : ");
		for (int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();
//		-------------------
	}

	public void deepCopy() {
//		깊은 복사 : 새로운 배열을 하나 생성하고 값을 복사
		int oriArr[] = { 1, 2, 3, 4, 5 };
		int copyArr[] = new int[5];
		int arr3[] = oriArr.clone();
//		for문 사용해서 값을 복사
		for (int i = 0; i < oriArr.length; i++) {
			copyArr[i] = oriArr[i];
		}
//			System.out.println(arr3[i] + " ");

		System.out.print("1. oriArr : ");
		for (int i = 0; i < oriArr.length; i++) {
			System.out.print(oriArr[i] + " ");

		}
		System.out.println();
		System.out.print("2. copyArr : ");
		for (int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();
//		원본 배열과 복사 배열의 값을 따로 변경
		oriArr[0] = 99;
		copyArr[3] = 33;
//		새로운 배열을 생성하고 배열에 직접 값을 지정 해주었기 때문에 
//		배열마다 주소도 다르기때문에, 값을 변경해도 바뀌지 않는다

//		-------------------
		System.out.println("--------수 정 후---------");
		System.out.print("1. oriArr : ");
		for (int i = 0; i < oriArr.length; i++) {
			System.out.print(oriArr[i] + " ");

		}
		System.out.println();
		System.out.print("2. copyArr : ");
		for (int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();
//		-------------------
	}

	public void deepCopy02() {
//		arraycopy() 메소드 사용
//		java.lang.System

		int oriArr[] = { 1, 2, 3, 4, 5 };
		int copyArr[] = new int[10];

//		arraycopy (원본배열, 복사할 위치(index),복사받을 배열, 붙여넣을 위치(index),길이(얼마나복사할건지) 
		System.arraycopy(oriArr, 0, copyArr, 4, oriArr.length-3);

//		arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
//		src: 원본배열, srcPos:복사시작 위치, dest:복사받을 배열, destPos:붙여넣기 시작위치
//		length: 복사할 길이 (얼마나 복사할 것인지)

//		---------------------
		System.out.print("1. oriArr : ");
		for (int i = 0; i < oriArr.length; i++) {
			System.out.print(oriArr[i] + " ");

		}
		System.out.println();
		System.out.print("2. copyArr : ");
		for (int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();
	}

	
	public void deepCopy03() {
//		 clone()을 이용한 복사
		int oriArr[]= {1,2,3,4,5};
		int copyArr[];
		
		copyArr=oriArr.clone();
//		복사한 새로운배열을 copyArr이 참조.
		
		
//		-------------
		System.out.print("1. oriArr : ");
		for (int i = 0; i < oriArr.length; i++) {
			System.out.print(oriArr[i] + " ");

		}
		System.out.println();
		System.out.print("2. copyArr : ");
		for (int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i] + " ");
		}
		System.out.println();
//		-------------
	}
}