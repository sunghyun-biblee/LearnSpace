package com.collection.silsub1.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.collection.silsub1.model.dao.BookDao;
import com.collection.silsub1.model.vo.Book;

public class BookManager {
	private BookDao bd = new BookDao();
	private Scanner sc = new Scanner(System.in);

	public BookManager() {

	}

	public void addBook(Book book) {
// 		리스트에 도서가 하나도 없을경우, 즉 첫 도서 등록일 경우 예외발생
//		-> 어떤예외인지 알아보고 try,catch문을 이용하여 오류해결
		try {
//			전달받은 Book 객체의 도서번호를 setter메소드를 통해 설정
			book.setbNo(bd.getLastBookNo() + 1);
		} catch (IndexOutOfBoundsException e) {
			book.setbNo(1);
		}
//		BookDao의 addBook()메소드로 해당 Book객체 전달
		bd.addBook(book);
	}

	public int deleteBook(int no) {
		return bd.deleteBook(no);

	}

	public int searchBook(String title) {
		return bd.searchBook(title);
	}

	public Book selectBook(int index) {
		return bd.selectBook(index);
	}

	public ArrayList<Book> selectAll() {
		return bd.selectAll();

	}

	public Book[] sorteBookList() {
		ArrayList<Book> list = bd.sortedBookList();
//		book 배열을 하나 만들고 사이즈는 리스트의 길이 만큼 만든다.
		Book[] bk = new Book[list.size()];
		for (int i = 0; i < bk.length; i++) {
			bk[i] = list.get(i);
		}
		return bk;

	}

	public void printBookList(Book br[]) {
		for(Book tmp :br) {
			System.out.println(tmp);
		}
	}

}
