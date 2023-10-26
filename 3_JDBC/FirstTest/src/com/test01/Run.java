package com.test01;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Run {
	
//2022년 4월 24일 일요일 오후9시 29분9초 kst
	public static void main(String[] args) {
		Board board = new Board();
		ArrayList<Board> blist=new ArrayList();
		
		Board obj=null;
		Calendar calendar=Calendar.getInstance();
		calendar.clear();
		Calendar cal= (Calendar) calendar.clone();
		cal.set(2022,4-1,24);
		cal.add(Calendar.HOUR_OF_DAY, 21);
		cal.add(Calendar.MINUTE, 29);
		cal.add(Calendar.SECOND, 9);
//		System.out.println(cal.getTime());
		Date date=cal.getTime();
		
		if(blist.isEmpty()==true) {
			obj=new Board(1,"안녕하세요","홍길동",date,"처음 작성 하는 글입니다.");
			obj.setReadCount(1);
			blist.add(obj);
//			System.out.println("추가성공");
		}else {
			System.out.println(blist.size());
		}
		
		for (int i =0; i<blist.size();i++) {
			System.out.println(blist.get(i));
			switch(i) {
			case 0:
				obj=new Board(2,"반가워요","김유신",date,"글을 처음으로 적어보내요.");
				obj.setReadCount(3);
				blist.add(obj);
				break;
			case 1:
				obj=new Board(3,"가입했습니다","이순신",date,"만나서 반갑습니다 등업부탁해요.");
				obj.setReadCount(22);
				blist.add(obj);
				break;
			case 2:
				obj=new Board(4,"무슨일이시죠?","유관순",date,"접속이 잘 안되네요ㅠ");
				obj.setReadCount(14);
				blist.add(obj);
				break;
			case 3:
				obj=new Board(5,"물어볼게 있습니다","신사임당",date,"탈퇴는 어떻게 하는건가요?");
				obj.setReadCount(9);
				blist.add(obj);
				break;
			default:
				return;
			}
			
		}
   
	}



	
	
	
}
