package com.mvc.dto;

import java.util.Date;

public class MyMVCDto {
	// 필드
	private int seq;
	private String writer;
	private String title;
	private String content;
	private Date regdate;
	
	// 생성자(기본, 매개변수)
	public MyMVCDto() {
		super();
	}
	public MyMVCDto(int seq, String writer, String title, String content, Date regdate) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String wirter) {
		this.writer = wirter;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "seq=" + seq + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", regdate=" + regdate;
	}
	
	
	
	
}
