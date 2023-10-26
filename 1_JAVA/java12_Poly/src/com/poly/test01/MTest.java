package com.poly.test01;

import java.util.Scanner;

public class MTest {

	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.bark();
		cat.eat("생선");

		Animal dog = new Dog();

		dog.bark();
		dog.eat("뼈다귀");

//		 동적바인딩 - 실행 시 메모리 할당을 하면서 메소드를 동적으로 연동하는 방식
//		동적바인딩을 이용하면 코드를 더 깔끔하게 쓸 수 있다.

		System.out.println("선택[1:고양이 2:강아지]:");
		int select = new Scanner(System.in).nextInt();
		Animal ani = null;
		switch (select) {
		case 1:
			ani = new Cat();
			break;
		case 2:
			ani = new Dog();
			break;
		}
		ani.bark();
		ani.eat("점심");

	}

}
