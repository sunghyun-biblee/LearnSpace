package com.test03;

public class Developer {
	private Emp emp;
	private String dept;
	public Developer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Developer(Emp emp, String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return emp + "\t 부서 :"	+ dept;
	}
	
	
	
}
