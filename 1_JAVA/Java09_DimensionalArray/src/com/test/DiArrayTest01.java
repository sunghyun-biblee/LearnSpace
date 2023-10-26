package com.test;

public class DiArrayTest01 {
	public static void main(String[] args) {
		DiArrayTest01 di = new DiArrayTest01();
		di.testInit01();
	}

	public void testInit01() {
//		스택(Stack), 2차원 배열의 선언
		int iarr1[][];
		int iarr2[][];

//		할당(Heap), heap 영억에 배열의 공간을 만든다.
		iarr1 = new int[3][5];

		iarr2 = new int[3][];
		iarr2[0] = new int[5];
		iarr2[1] = new int[3];
		iarr2[2] = new int[5];

//		얕은 복사
//		int arr[]=iarr1[1];

//		배열의 값을 출력하는 이중 for문
		for (int i = 0; i < iarr2.length; i++) {
			for (int j = 0; j < iarr2[i].length; j++) {
				System.out.print(iarr2[i][j] + " ");
			}
			System.out.println();
		}

		// 2차원 배열에 값을 기록
		// 인덱스로 접근하여 값을 기록
		iarr1[0][0] = 1;
		iarr1[0][1] = 2;
		iarr1[0][2] = 3;
		iarr1[1][1] = 4;
		iarr1[1][4] = 5;
		iarr1[2][1] = 6;
		iarr1[2][3] = 7;

//		printArr(iarr1); // iaar1을 printArr메소드의 파라미터에 넘겨주면서 출력해라
		
		
		//다차원 배열의 할당과 초기화를 동시에 할 수도 있다.
		int iarr3[][]= {{1,2,3},{4,5,6,7},{8,9,10,11}};
		printArr(iarr3);
	}

	public void printArr(int iarr[][]) {
		for (int i = 0; i < iarr.length; i++) {
			for (int j = 0; j < iarr[i].length; j++) {
				System.out.print("\t" + iarr[i][j]);

			}
			System.out.println();
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
}
