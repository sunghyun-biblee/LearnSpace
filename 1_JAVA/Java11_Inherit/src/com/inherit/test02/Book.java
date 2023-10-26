package com.inherit.test02;

public class Book {
	// 필드
	private String title;
	private String writer;
	private int price;

	// 생성자
	public Book() {
	}
	
	public Book(String title) {
		this.title = title;
	}

	public Book(String title, String writer, int price) {
		this.title = title;
		this.writer = writer;
		this.price = price;
	}
	// 숙제
	// getter & setter 만들기
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer=writer;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price=price;
	}
	
	

	
	

	//////
	// Object의 toString은 풀패키지명과 객체 해쉬코드를 16진수등오로 변환하여 리턴
	@Override
	public String toString() {
		return title + "," + writer + "," + price;
	}

	/////
	// 두 객체의 주소값을 비교해서 같으면 true, 다르면 false 를 리턴하는 메소드
	// 객체가 가진 값까지 비교하기 위한 목적으로 오버라이딩

	@Override
	public boolean equals(Object obj) {

		// 객체의 주소가 같으면 같은 객체
		if (this == obj) {
			return true;
		}

		// 전달받은 객체(obj가) null인 경우 무조건 다른 객체
		if (obj == null) {
			return false;
		}

//		각 필드별로 비교를 시작 !!

		////////////////////////
//		부모클래스 타입에 변수에는 자식클래스 객체가 저장된다.
//		 Book 타입의 객체가 들어있는 Object 타입의 obj 매개변수를 형변환을 통해 Book으로 변경
		Book other = (Book) obj;
		if (this.title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) { // 두 객체의 title이 서로 다른 경우 return false;
			return false;
		}

//		writer를 비교. title과 동일한 방식
		if (writer == null) {
			if (other.writer != null) {
				return false;
			}
		} else if (!writer.equals(other.writer)) { // 두 객체의 title이 서로 다른 경우 return false;
			return false;
		}
		
		
		if(price !=other.price) {
			return false;
		}
		
		
		return true;
	}
	
	
	@Override
	public int hashCode() {
		return (title+writer+price).hashCode();
	}
	
	
	
	
	
	
	
	

}
