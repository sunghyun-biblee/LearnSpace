package com.collection.silsub1.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.collection.silsub1.controller.BookManager;
import com.collection.silsub1.model.vo.Book;

public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	private BookManager bm = new BookManager();
	private Book book = new Book();

	public BookMenu() {
	}

	public void mainMenu() {

		while (true) {
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서정보 정렬 후 출력");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 도서 검색 출력");
			System.out.println("5. 전체 출력");
			System.out.println("6. 끝내기");

			System.out.println("메뉴 번호 선택");
			int num = sc.nextInt();
			sc.nextLine();
			switch (num) {
			case 1:
//				inputbook을 실행한 객체를 저정 후 도서추가메소드의 메개변수로 전달
//				Book b=inputBook();
//				bm.addBook(b);
				bm.addBook(inputBook());
				break;
			case 2:
				bm.printBookList(bm.sorteBookList());
				break;
			case 3:
				int result=bm.deleteBook(inputBookNo());
//				int result2 = bm.deleteBook(inputBooktitle());
//				제목으로 삭제 하고싶을 때
				if(result > 0 ) {
					System.out.println("성공적으로 삭제되었습니다");
				}else {
					System.out.println("삭제할 도서가 존재하지 않습니다.");
				}
				
				break;
			case 4:
				int index = bm.searchBook(inputBooktitle());
				if(index== -1) {
					System.out.println("조회한 책이 없습니다");
				}else {
					System.out.println(bm.selectBook(index));
				}
				break;
			case 5:
//				리스트 전체 출력
				ArrayList<Book> list = bm.selectAll();
//				bm.selectAll();
				
				
//				결과 리스트 리턴 받아 비어있을 경우 “없습니다.”
//				아닐 경우 Iterator를 이용하여 전체 출력
//				iterator : 컬렉션 프레임워크에서 "값을 가져오거나 삭제" 하는데 사용한다
				
				if(list.isEmpty()) {
					System.out.println("도서가 없습니다.");
				}else {
					Iterator<Book> it=list.iterator();
					while(it.hasNext()) {
						System.out.println(it.next());
					}
				}

				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				return;
			}

		}

//		switch (num) {
//		case 1:
//			bm.addBook(inputBook());
//			break;
//		case 2:
//			bm.sorteBookList();
//			break;
//		case 3:
//			bm.deleteBook(inputBookNo());
//			break;
//		case 4:
//			bm.searchBook(inputBooktitle());
//			break;
//		case 5:
//			bm.selectAll();
//			break;
//		case 6:
//			mainMenu();
//			break;
//		default:
//		}
	}

	public Book inputBook() {
//		제목,장르,작가 입력받아서 Book객체에 저장 후 리턴
		System.out.println("도서제목 : ");
		String title = sc.nextLine();

		System.out.println("1: 인문 / 2: 자연과학 / 3: 의료 / 4: 기타");
		int category = sc.nextInt();

		sc.nextLine();

		System.out.println("도서 저자");
		String author = sc.nextLine();

		return new Book(category, title, author);

	}

	public int inputBookNo() {
		System.out.println("삭제할 도서 번호 :");
		int bNum = sc.nextInt();
		sc.nextLine();
		return bNum;

	}

	public String inputBooktitle() {
		System.out.println("조회할 도서 제목 : ");
		String bName = sc.nextLine();
		return bName;

	}

}
