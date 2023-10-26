package com.collection.part03_map_hashMap;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
	public void testHashMap() {
		HashMap hmap = new HashMap();

//		키와 값 쌍으로 저장 => 키&값을 묶어 Entry(엔트리)로 부른다. map은 Entry 단위로 관리 
//		키,값 둘 다 반드시 객체
		hmap.put("one", new Date());
		hmap.put(12, "red apple");
		hmap.put(33, 123);

		System.out.println("hmap: " + hmap);

//		hmap.put(hmap, hmap) // 첫번째 변수가 키, 두번째 변수가 데이터(value)
		hmap.put(12, "school"); // 키의 값이 같을경우 중복되어 저장되지 않는다
		System.out.println("hmap: " + hmap);

		hmap.put(13, "school"); // 키의 값이 같은경우 중복되지않으나, 데이터(value)가 같은경우는 중복저장된다.
		hmap.put(14, "school");
		System.out.println("hmap: " + hmap);

//		키 값을 가지고 객체를 가져올 수 있다.
//		get(Key)
		System.out.println("키 14에 대한 객체 : " + hmap.get(14));

//		키 값을 가지고 삭제 처리
		hmap.remove(14);
		System.out.println("hmap: " + hmap);

		hmap.clear();

		System.out.println();

//		Map에 저장된 객체 연속 처리
	
		hmap.put("one", "java 11");
		hmap.put("two", "mysql");
		hmap.put("three", "JDBC");
		hmap.put("four", "HTML5");
		hmap.put("five", "CSS3");
//		1. keySet() :Key만 따로 set으로 만들고 iterator()로 목록 만들어 연속처리
		Set keys = hmap.keySet();

		Iterator keyIter = keys.iterator();
		System.out.println(keys);
		int num=0;
		while (keyIter.hasNext()) {
			String key = (String) keyIter.next();
			String value = (String) hmap.get(key);
			System.out.println(key + "=" + value);
			System.out.println(keys.size());
			num=keys.size();
		}
		System.out.println(":"+num);

//		2.entrySet()  : Map 내부 클래스인 Entry(키와 벨류를 쌍으로 묶은 것)를 활용
		Set eSet = hmap.entrySet(); //커플들은 eSet에다가 저장
		Iterator entryIter = eSet.iterator(); // 커플들을 줄세워서 entryIter에 저장
 
		while (entryIter.hasNext()) {  // entryIter에 줄세워 놓은 커플들은 하나씩 호출 , 남는 커플이 없을때까지 (뒤에 오는 entry가 없을 때 까지)
			Map.Entry entry = (Map.Entry) entryIter.next();
			System.out.println(entry.getKey()+" : "+entry.getValue());
			
		}

	}
}
