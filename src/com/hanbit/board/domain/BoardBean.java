package com.hanbit.board.domain;

import java.util.Date;

public class BoardBean {

	private int seq;
	private String writer,title,content,regdate;

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq=seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	/*public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}*/
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String toString(){
		return "글번호 : "+seq+"작성자 : "+writer+"제목 :"+title+"내용 : "+content+"작성일 : "+regdate ;
	}
}
