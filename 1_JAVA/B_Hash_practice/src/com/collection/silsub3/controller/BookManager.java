package com.collection.silsub3.controller;

import java.util.HashMap;
import java.util.Scanner;

import com.collection.silsub3.model.dao.BookDao;
import com.collection.silsub3.model.vo.Book;

public class BookManager {
	Scanner sc = new Scanner(System.in);
	BookDao bd = new BookDao();

	public BookManager() {
	}

	public void addBook(Book book) {
		
		int two=bd.getLastBookNo()+1;
		String thr=String.valueOf(two);
		book.setbNo(thr);
		bd.addBook(book);
	}

	public Book deleteBook(String key) {
		return bd.deleteBook(key);
	}

	public String searchBook(String title) {
		return bd.searchBook(title);
	}

	public Book selectBook(String key) {
		
		return bd.selectBook(key);
	}

	public HashMap<String, Book> selectAll() {
		return bd.selectAll();
	}

	public Book[] sortedBookList() {
		return null;
	}

	public void printBookList(Book[] br) {

	}
}
