package com.ms.web2.sns;

import java.util.Date;

public class Reply {
//	sre_no number(4) primary key,
//	sre_sns_no number(3) not null,
//	sre_writer varchar2(10 char)not null,
//	sre_txt varchar2 (150 char)not null,
//	sre_date date not null,
	
	private int no;
	private int sreno;
	private String writer;
	private String txt;
	private Date date;
	
	public Reply() {
		// TODO Auto-generated constructor stub
	}
	
	public Reply(int no, int sreno, String writer, String txt, Date date) {
		super();
		this.no = no;
		this.sreno = sreno;
		this.writer = writer;
		this.txt = txt;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getSreno() {
		return sreno;
	}

	public void setSreno(int sreno) {
		this.sreno = sreno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

	

}
