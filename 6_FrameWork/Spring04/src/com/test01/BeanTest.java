package com.test01;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class BeanTest {

	private MyClass myclass;
	
	public BeanTest() {
		System.out.println("기본 생성자(no-args)");
	}

	public BeanTest(Date date) {
		System.out.println("날짜 생성자(date: "+date+")");
	}

	public MyClass getMyclass() {
		return myclass;
	}

	public void setMyclass(MyClass myclass) {
		this.myclass = myclass;
		System.out.println("setMyclass() 호출: "+ myclass);
	}
	
	public void setDate(Date date) {
		System.out.println("setDate() 호출: "+ date);
	}
	
	public void setNumber(int num) {
		System.out.println("setNumber() 호출: "+ num);
	}
	
	public void setArray(String arr[]) {
		System.out.println("setArray() 호출"	);
		for(String str:arr) {
			System.out.println("출력: "+ str);
		}
	}
	
	public void setList(List<String> list) {
		System.out.println("setList() 호출");
		for(String str:list) {
			System.out.println("출력: "+str);
		}
	}
	
	public void setMap(Map<String,String> map) {
		System.out.println("setMap() 호출");
		System.out.println(map);
	}
	
	public void setScore(List<Score> list) {
		System.out.println("setScore() 호출");
		System.out.println(list);
	}
	
}
