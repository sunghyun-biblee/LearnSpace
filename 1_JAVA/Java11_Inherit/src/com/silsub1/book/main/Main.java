package com.silsub1.book.main;


import com.silsub1.book.model.Book;
public class Main {

	public static void main(String[] args) {
			Book b1=new Book("멀티","캠퍼스",1000);
			Book b2=new Book("삼성","캠퍼스",2000);
			System.out.println(b1);
			System.out.println(b2);
			System.out.println(b1.toString());
			System.out.println(b2.toString());
			System.out.println("b1==b2? :"+b1.equals(b2));
			
			//얕은복사
			Book b3=b1;
			
			System.out.println("b1==b3? :"+b1.equals(b3));
			
			Book b4=new Book(b1.getTitle(),b1.getAuthor(),b1.getPrice());
			
			System.out.println(b4.equals(b1));
			
			System.out.println(b1.hashCode());
			System.out.println(b4.hashCode());
			
			
			
			
	}

}
