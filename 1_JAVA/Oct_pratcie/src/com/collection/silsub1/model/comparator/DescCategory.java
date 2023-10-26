package com.collection.silsub1.model.comparator;

import java.util.Comparator;

import com.collection.silsub1.model.vo.Book;

public class DescCategory implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		int other1 = o1.getCategory();
		int other2 = o1.getCategory();
		if (other1 > other2) {
			return -1;
		} else if (other1 < other2) {
			return 0;
		} else {
			return 0;
		}

	}
}
