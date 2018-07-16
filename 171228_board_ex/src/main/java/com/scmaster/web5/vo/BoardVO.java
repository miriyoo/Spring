package com.scmaster.web5.vo;

public class BoardVO {
	private int boardNo;
	private String boardName;
	private String boardPassword;
	private String boardContent;
	private String boardDate;
	
	public BoardVO(){
		
	}

	public BoardVO(int boardNo, String boardName, String boardPassword, String boardContent, String boardDate) {
		super();
		this.boardNo = boardNo;
		this.boardName = boardName;
		this.boardPassword = boardPassword;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getBoardPassword() {
		return boardPassword;
	}

	public void setBoardPassword(String boardPassword) {
		this.boardPassword = boardPassword;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", boardName=" + boardName + ", boardPassword=" + boardPassword
				+ ", boardContent=" + boardContent + ", boardDate=" + boardDate + "]";
	}
	
	
}
