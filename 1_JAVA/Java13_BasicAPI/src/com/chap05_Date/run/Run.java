package com.chap05_Date.run;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Run {

	public static void main(String[] args) {
		// 1. Date (java.util) // month는 저장할땐 -1 , 불러다 쓸땐 +1 사용
		Date today = new Date();
		System.out.println(today);

		Date oriDay = new Date(2000L);
		System.out.println(oriDay);
		oriDay=new Date(100+19,9-1,9);
		System.out.println(oriDay);

//		원하는 패턴으로 날짜 출력 => SimpleDateFormat 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd / hh시 mm분 ss초");
		System.out.println(sdf.format(today));
		// => sdf 객체를 활용하여 today의 값을 format(형식으로 정리) 할거야

		// 2. Calendar (java.util)
		System.out.println("====Calendar====");
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		calendar.set(2023, 10 - 1, 3);
		System.out.println(calendar);

		int year = calendar.get(1);
//		int month = calendar.get(2)+1;
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DATE);
		System.out.println(year + "년 ");
		System.out.println(month + "월 ");
		System.out.println(day + "일");

//		cal > 2023년 10월 3일 저장
		Calendar cal = (Calendar) calendar.clone();
		cal.add(Calendar.YEAR, -9); // 9년 전
		cal.add(Calendar.MONTH, -4); // 4개월 전
		cal.add(Calendar.DATE, +10); // 10일 후
//		System.out.println(cal.get);
//		cal.add(Calendar.HOUR, day)
		System.out.println(cal.getTime());
		System.out.println(sdf.format(cal.getTime()));

		// 대표적으로 게시글에서 사용 (시간찍힘)

		// 3. GregorianCalender (java.util) // 윤년을 계산하는 기능이 추가되어있음
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.getTime());
		System.out.println("year : " + gc.get(GregorianCalendar.YEAR));
		System.out.println(gc.get(Calendar.DATE));
		System.out.println(sdf.format(gc.getTime()));

		gc.set(2024, 10 - 1, 14);
		System.out.println(gc.getTime());
		System.out.println(new GregorianCalendar().isLeapYear(2024));
//	 	isLeapYear => 윤년인지 확인
//	 	is로 시작하는 메소드들은 무엇인지 확인하는 기능
	}

}
