package com.tst.common;


// 제목, 내용, 작성자, 작성일자, 방문횟수
public class Board {
	/*
	 * Field
	 */
	private int boardId;
	private String title;
	private String content;
	private String writer;
	private String createDate;
	private int visitCnt;

	/*
	 * Constructor
	 */
	public Board() {
		
	}
	
	public Board(int boardId, String title, String content, String writer, String createDate, int visitCnt) {
		super();
		this.boardId = boardId;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.createDate = createDate;
		this.visitCnt = visitCnt;
	}

	/*
	 * Method
	 */
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public int getVisitCnt() {
		return visitCnt;
	}
	public void setVisitCnt(int visitCnt) {
		this.visitCnt = visitCnt;
	}

}
