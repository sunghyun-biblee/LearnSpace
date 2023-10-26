package com.silsub1.book.model;

public class Book {
	//필드
	private String title;
	private String author;
	private int price;
	
	//생성자
	public Book() {}
	public Book(String title) {
		this.title=title;
}
	
	public Book(String title, String author, int price) {
		this.title=title;
		this.author=author;
		this.price=price;
	}
	
	
	//getter && setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author=author;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price=price;
	}
	
	
	
	@Override
	public String toString() {
		return title+","+author+","+price;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null) {
			return false;
		}
		
		Book other=(Book)obj;
		if(this.title==null) {
			if(other.title==null) {
				return false;
			}
		}else if(!title.equals(other.title)) {
			return false;
		}
		
		if(author==null) {
			if(other.author==null) {
				return false;
			}
		}else if(!author.equals(other.author)){
			return false;
		}
		
		
		if(price!=other.price) {
			return false;
		}
		
		return true;
		
	}
	
	@Override
	public int hashCode() {
		return (title+author+price).hashCode();
	}
	
	
	
	
	
	
}
