package com.ms.web2.photozone;

import java.util.Date;

public class PhotoZone {
	private int no;
	private String id;
	private String photo;
	private Date date;
	public PhotoZone() {
		// TODO Auto-generated constructor stub
	}
	public PhotoZone(int no, String id, String photo, Date date) {
		super();
		this.no = no;
		this.id = id;
		this.photo = photo;
		this.date = date;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
