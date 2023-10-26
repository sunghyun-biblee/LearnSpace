package com.collection.part01_list.arrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ArrayListTest {
	public void testArrayList() {
//		 ArrayList
		ArrayList alist = new ArrayList();

//		 다형성 적용
		List list = new ArrayList();
		Collection clist = new ArrayList();

//		arraylist는 저장 순서가 유지. index가 적용
//		객체만 저장할 수 있다.
		alist.add("apple");
		alist.add(123); // autoBoxing 처리
		alist.add(45.67);
		alist.add(new Date());

		System.out.println("alist: " + alist.get(3));

		// 인덱스가 지정 되어 있기에 for문으로 접근 가능
		for (int i = 0; i < alist.size(); i++) {
			System.out.println(i + " : " + alist.get(i));
		}

		alist.add(new Date());
		System.out.println("alist : " + alist);

//		객체를 중간에 추가하는 경우 해당 인덱스에 덮어 쓰는게 아닌
//		기존의 데이터들을 하나씩 뒤로 보내고 추가.

		alist.add(1, "banana");
		System.out.println("alist : " + alist);

//		리스트 중간에 들어있는 객체를 삭제하는 경우
//		삭제된 후 나머지 객체들이 자동으로 인덱스 하나씩 앞으로 당긴다.
		alist.remove(3);
		System.out.println("alist : " + alist);
		alist.remove(0);
		System.out.println("alist : " + alist);

		alist.set(1, false); // 리스트에 들어있는 객체를 수정
		System.out.println("alist : " + alist);

		//
		list.add("apple");
		list.add("grape");
		list.add("orange");
		list.add("banana");
		list.add("mango");

		System.out.println("list : " + list);

		
		// ArrayList는 오름차순 정렬 가능한 sort() 메소드 사용가능
		// 둘 중 아무거나 사용해도 상관없다.
		Collections.sort(list);
//		list.sort(null);
		System.out.println("list : " + list);
	}
}
