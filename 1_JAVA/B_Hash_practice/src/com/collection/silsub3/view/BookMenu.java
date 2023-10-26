package com.collection.silsub3.view;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import com.collection.silsub3.controller.BookManager;
import com.collection.silsub3.model.vo.Book;

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
//				
				bm.addBook(inputBook());
				break;
			case 2:
				bm.printBookList(bm.sortedBookList());
				break;
			case 3:
				Book result = bm.deleteBook(inputBookNo());
				break;
			case 4:
				String title = bm.searchBook(inputBooktitle());
				if (title == "") {
					System.out.println("조회한 책이 없습니다.");
				} else {
					System.out.println(title + bm.selectBook(title));
				}
				break;
			case 5:
				HashMap<String, Book> hmap = bm.selectAll();
				if (hmap.isEmpty()) {
					System.out.println("도서가 없습니다.");
				} else {
					for (Entry<String, Book> item : hmap.entrySet()) {
						System.out.println(item.getKey() + item.getValue());
					}
				}
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}

	}

	public Book inputBook() {

		System.out.println("도서제목 : ");
		String title = sc.nextLine();

		System.out.println("1: 인문 / 2: 자연과학 / 3: 의료 / 4: 기타");
		int category = sc.nextInt();

		sc.nextLine();

		System.out.println("도서 저자");
		String author = sc.nextLine();

		return new Book(category, title, author);

	}

	public String inputBookNo() {
		System.out.println("삭제할 도서 번호 :");
		String bNum = sc.nextLine();
		sc.nextLine();
		return bNum;

	}

	public String inputBooktitle() {
		System.out.println("조회할 도서 제목 : ");
		String bName = sc.nextLine();
		return bName;

	}

}
