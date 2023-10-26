package com.collection.silsub1.model.dao;

import java.util.ArrayList;

import com.collection.silsub1.model.comparator.AscCategory;
import com.collection.silsub1.model.vo.Book;

public class BookDao {
	private ArrayList<Book> bookList = new ArrayList<Book>();

	public BookDao() {
		// bookList객체를 생성함
		bookList = new ArrayList<Book>();
	}

	public BookDao(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}

//	 마지막 도서 번호 리턴
	public int getLastBookNo() {

//		return bookList.lastIndexOf(bookList);
		return bookList.get(bookList.size() - 1).getbNo();

//		예외가 발생했을때 if문으로 예외처리를 할 수 있다.
//		if(bookList.size()==0) {
//			return 0;
//		} else {
//			return bookList.get(bookList.size()-1).getbNo();
//		}

	}

//	새 도서 추가
	public void addBook(Book Book) {
		bookList.add(Book);

	}

//  도서 삭제 
	public int deleteBook(int no) {
		int result = 0;
//		리스트에서 i번째 도서를 하나씩 다 비교해본다
//		삭제를 원하는 도서의 번호와 일치하다면 해당 도서(객체)를 삭제한다.
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getbNo() == no) {
//		해당하는 번호의 도서를 삭제 ( (배치된 도서의 번호) i == no (삭제를 원하는 도서의 번호))
				bookList.remove(i);
				result = 1;
				break;
			}
		}
		
		return result;
	}

//	도서 검색
	public int searchBook(String title) {
		int index = -1;

		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getTitle().contains(title)) {
//				contains : 변수가 포함되어있는지 확인하는 클래스
				index = i;
				break;
			}

		}
		return index;

	}

//	해당 인덱스 값을 이용한 Book 객체 리턴
	public Book selectBook(int index) {
		return bookList.get(index);

	}

//	전체 출력
	public ArrayList<Book> selectAll() {
		return bookList;

	}

//	정렬 처리 후 list 리턴
	public ArrayList<Book> sortedBookList() {
//		.sort => 정렬
//		bookList를 AscCategory메소드를 이용하여 오름차순으로 정렬
		bookList.sort(new AscCategory());
		return bookList;

	}

}
