package com.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class School {
	// bean에서 생성한 student 타입의 빈이 자동으로 person에 들어가게됨
	@Autowired
	@Qualifier("biblee2") // 자동으로 빈을 넣는 과정에서 동일한 타입의빈이 들어올 시 지정한 이름의 빈을 넣어준다
	private Student person;
	
	private int grade;
	
	public School() {}
	
	public School(Student person, int grade) {
		super();
		this.person = person;
		this.grade = grade;
	}
	
	public Student getPerson() {
		return person;
	}
	
	public void setPerson(Student person) {
		this.person = person;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "School [person=" + person + ", grade=" + grade + "]";
	}
	
	
}
