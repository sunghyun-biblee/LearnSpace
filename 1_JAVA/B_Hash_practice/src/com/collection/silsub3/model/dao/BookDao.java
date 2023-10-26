package com.collection.silsub3.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.collection.silsub3.model.vo.Book;

public class BookDao {
	private HashMap<String, Book> hmap = new HashMap<String, Book>();

	public BookDao() {
		hmap = new HashMap<String, Book>();
	}

	public BookDao(HashMap<String, Book> hmap) {
		this.hmap = hmap;
	}

	public int getLastBookNo() {
		Set keys = hmap.keySet();
		Iterator keyIter = keys.iterator();
		int num = 0;
		System.out.println(hmap);
		System.out.println(keys.size());

		while (keyIter.hasNext()) {
			num = keys.size();
			break;
		}

		return num;

	}

	public void addBook(Book book) {
		hmap.put(book.getTitle(), book);
		System.out.println(hmap);
	}

	public Book deleteBook(String key) {
		Set keys = hmap.keySet();
		Book BookMap;
		if (hmap.containsKey(key)) {
			hmap.remove(key);
			BookMap = hmap.remove(keys);
		}

		return hmap.remove(key);

	}

	public String searchBook(String title) {
		String str = "";
		if (hmap.containsKey(title)) {
			str = title;
		} else {
			str = "";
		}
		return str;
	}

	public Book selectBook(String key) {

		return hmap.get(key);
	}

	public HashMap<String, Book> selectAll() {
		return hmap;

	}

	public ArrayList<Book> sortedBookList() {
		return null;

	}

}
