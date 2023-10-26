
//package com.test01;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Date;
//
//
//public class Run2 {
//	
////2022년 4월 24일 일요일 오후9시 29분9초 kst
//	public static void main(String[] args) {
//		Board board = new Board();
//		ArrayList<Board> blist=new ArrayList();
//		 
//		blist.add(new Board(1,"안녕하세요","홍길동",new Date(100+22,4-1,24),"처음 작성 하는 글입니다."));
//		blist.add(new Board(2,"반가워요","김유신",new Date(100+22,4-1,24),"글을 처음으로 적어보내요."));
//		blist.add(new Board(3,"가입했습니다","이순신",new Date(100+22,4-1,24),"만나서 반갑습니다 등업부탁해요."));
//		blist.add(new Board(4,"무슨일이시죠?","유관순",new Date(100+22,4-1,24),"접속이 잘 안되네요ㅠ"));
//		blist.add(new Board(5,"물어볼게 있습니다","신사임당",new Date(100+22,4-1,24),"탈퇴는 어떻게 하는건가요?"));
//		
//		Board obj=null;
//		obj=new Board(1,"안녕하세요","홍길동",new Date(100+22,4-1,24),"처음 작성 하는 글입니다.");
//		obj.setReadCount(1);
//		blist.add(obj);
//		System.out.println(blist);
//		System.out.println("123");
//		if(blist.isEmpty()==true) {
//			obj=new Board(1,"안녕하세요","홍길동",new Date(100+22,4-1,24),"처음 작성 하는 글입니다.");
//			obj.setReadCount(1);
//			blist.add(obj);
//			System.out.println("추가성공");
//		}else {
//			System.out.println(blist.size());
//		}
//		
//		for (int i =0; i<blist.size();i++) {
//			System.out.println(blist.get(i));
//			switch(i) {
//			case 0:
//				obj=new Board(2,"반가워요","김유신",new Date(100+22,4-1,24),"글을 처음으로 적어보내요.");
//				obj.setReadCount(3);
//				blist.add(obj);
//				break;
//			case 1:
//				obj=new Board(3,"가입했습니다","이순신",new Date(100+22,4-1,24),"만나서 반갑습니다 등업부탁해요.");
//				obj.setReadCount(22);
//				blist.add(obj);
//				break;
//			case 2:
//				obj=new Board(4,"무슨일이시죠?","유관순",new Date(100+22,4-1,24),"접속이 잘 안되네요ㅠ");
//				obj.setReadCount(14);
//				blist.add(obj);
//				break;
//			case 3:
//				obj=new Board(5,"물어볼게 있습니다","신사임당",new Date(100+22,4-1,24),"탈퇴는 어떻게 하는건가요?");
//				obj.setReadCount(9);
//				blist.add(obj);
//				break;
//			default:
//				return;
//			}
//			
//		}
//	
//	int j=0;
//	
//	do {
//		System.out.println(blist.get(j));
//	}while(blist.size()<j);
//	for (int j = 0; j<blist.size();j++) {
//		System.out.println(blist.get(j));
//	}
//	
//	
//	int j = 0;
//	 do {
//		 switch()
//	 }while(blist.size()<j);
//     
//	}
//
//System.out.println(blist.get(1));
//System.out.println(blist.get(2));
//System.out.println(blist.get(3));
//		System.out.println(blist.get(1));
//		
//		for (int i = 0; i < blist.size(); i++) {
//			System.out.println(i + " : " + blist.get(i));
//			if(((Board) blist.get(i)).getBoardNo()==1) {
//			blist.set(0,1);
//			System.out.println("123123"+blist.get(0));
//			}
//		}
//		int i=0;
//		do {
//			
//			switch(((Board) blist.get(i)).getBoardNo()) {
//			case 1:
//				blist.set(0, 1);
//				System.out.println(blist.get(i));
//				break;
//			case 2:
//				blist.set(0, 13);
//				System.out.println(blist.get(i));
//				break;
//			case 3:
//				blist.set(0, 22);
//				System.out.println(blist.get(i));
//				break;
//			case 4:
//				blist.set(0, 14);
//				System.out.println(blist.get(i));
//				break;
//			case 5:
//				blist.set(0, 9);
//				System.out.println(blist.get(i));
//				break;
//			case 6:	
//				System.out.println("!");
//				break;
//			}
//			i++;
//		}while(blist.size()<i);
//		System.out.println(blist.get(i));
//		System.out.println(blist.get(1).getBoardNo());
//	
//	
//	
//	
//	  System.out.println(blist.get(i));
//	  System.out.println(blist.get(0).getReadCount());
//	  System.out.println(blist.get(1).getBoardNo());
//	  System.out.println(blist.get(2).getBoardNo());
//	  System.out.println(blist.get(3).getBoardNo());
//	 
//}
