package com.test01;

import java.util.Date;

public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardWrtier;
	private Date boardDate;
	private String boardContent;
	private int readCount;

	public Board() {

	}

	public Board(int boardNo, String boardTitle, String boardWrtier, Date boardDate, String boardContent) {
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardWrtier = boardWrtier;
		this.boardDate = boardDate;
		this.boardContent = boardContent;
		
	}
	
	

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardWrtier() {
		return boardWrtier;
	}

	public void setBoardWrtier(String boardWrtier) {
		this.boardWrtier = boardWrtier;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardWrtier=" + boardWrtier
				+ ", boardDate=" + boardDate + ", boardContent=" + boardContent + ", readCount=" + readCount + "]";
	}
}
