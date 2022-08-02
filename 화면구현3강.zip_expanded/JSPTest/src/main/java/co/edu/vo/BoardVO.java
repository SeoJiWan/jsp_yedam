package co.edu.vo;

import java.sql.Date;

public class BoardVO {
	/*
	 * Field
	 */
	private int boardId;
	private String title;
	private String writer;
	private String content;
	private Date write_date;
	private int visit_cnt;

	/*
	 * Method
	 */
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	public int getVisit_cnt() {
		return visit_cnt;
	}
	public void setVisit_cnt(int visit_cnt) {
		this.visit_cnt = visit_cnt;
	}


}
