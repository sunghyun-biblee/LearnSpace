package com.collection.part02_set.hashSet;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
	public void testHashSet() {
//		HashSet
		HashSet hset = new HashSet();
		Set hest2 = new HashSet(); // Set은 중복저장을 허용하지 않는다.
		Collection hset3 = new HashSet();

		hset.add("java");
		hset.add(123);
		hset.add(45.67);
		hset.add(new Date());

//		저장 순서 유지 안됨
		System.out.println("hset: " + hset);

//		정복허용 안함
		hset.add("java");
		hset.add(123);
		System.out.println("hset: " + hset);

//		저장된 객체를 하나씩 꺼내는 기능이 없다
//		1. toArray()
		Object arr[] = hset.toArray();
		for (Object obj : arr) {
			System.out.println(obj);
		}
		
//		2.Iterator()로 목록 만들어 연속처리
		Iterator iter=hset.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
//		3. 삭제 (Delete)
		hset.clear();
		System.out.println("is Empty :"+hset.isEmpty());
		
		
		
		
	}
}
