package com.mapping.mvc.dto;

public class AddressDto {
	private String name;
	private String addr;
	private String phone;
	
	public AddressDto() {
		super();
		System.out.println("constructor1");
	}
	
	public AddressDto(String name, String addr, String phone) {
		super();
		this.name = name;
		this.addr = addr;
		this.phone = phone;
		System.out.println("constructor2");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
