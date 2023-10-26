package com.collection.part01_list.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreManager {
	public static void main(String[] args) {
//		<Score> => < > : 제네릭스
		List<Score> list = new ArrayList<Score>();
		list.add(new Score("조성현", 99));
		list.add(new Score("조성현2", 98));
		list.add(new Score("조성현3", 94));
		list.add(new Score("조성현4", 96));
		list.add(new Score("조성현5", 95));
		list.add(new Score("조성현6", 97));

		System.out.println("list : " + list);
//		정렬
//		Comparable - 기본 정렬 기준을 구현 , 기본적으로 적용되는 정렬 기준

//		System.out.println("조성현".compareTo("조성현3"));

		list.sort(null);
		System.out.println("list: " + list);
		list.sort(new ScoreDesc());
		Collections.sort(list,new ScoreAsc());
		System.out.println("list: " + list);
		
		
		
	}

}
