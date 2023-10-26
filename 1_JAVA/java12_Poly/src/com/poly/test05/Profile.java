package com.poly.test05;

public class Profile {
	// 필드
	private String name;
	private String phone;

	// 생성자
	public Profile() {
	}

	public Profile(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	// getter && setter
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String Phone) {
		this.name = name;
	}

	public void printProfile() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phone);
	}
}
