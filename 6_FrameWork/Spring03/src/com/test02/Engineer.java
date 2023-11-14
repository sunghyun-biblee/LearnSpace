package com.test02;

public class Engineer extends Emp{
	
	private String engi;
	
	public Engineer() {
		
	}
	public Engineer(String name,int salary) {
		super(name,salary);
	}
	
	public void setEngi(String engi) {
		this.engi=engi;
	}
	
	@Override
	public String toString() {
		return super.toString()+"\t 부서:" + engi;
	}
}
