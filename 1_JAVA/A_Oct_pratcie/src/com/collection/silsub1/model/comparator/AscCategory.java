package com.collection.silsub1.model.comparator;

import java.util.Comparator;

import com.collection.silsub1.model.vo.Book;

public class AscCategory implements Comparator<Book> {

	public int compare(Book o1, Book o2) {
		
	
		return o1.getCategory()	- o2.getCategory();
	}
}
