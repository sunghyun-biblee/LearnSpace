package com.test02;

import java.sql.Date;

public class Board {
	private int bno;
	private String btitle;
	private String bwriter;
	private String bcont;
	private Date bDate;

	public Board() {
	}

	public Board(int bno, String btitle, String bwriter, String bcont, Date bDate) {
		this.bno = bno;
		this.btitle = btitle;
		this.bwriter = bwriter;
		this.bcont = bcont;
		this.bDate = bDate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBcont() {
		return bcont;
	}

	public void setBcont(String bcont) {
		this.bcont = bcont;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	@Override
	public String toString() {
		return "Board [" + bno + "	" + btitle + "	" + bwriter + "	" + bcont + "	"
				+ bDate + "]";
	}
}
