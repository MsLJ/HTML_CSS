package com.ms.web2.member;

import java.util.Date;

public class Member {
	private String id;
	private String pw;
	private String name;
	private int age;
	private String adr;
	private Date birthday;
	private String photo;

public Member() {
	// TODO Auto-generated constructor stub
}

public Member(String id, String pw, String name, int age, String adr, Date birthday, String photo) {
	super();
	this.id = id;
	this.pw = pw;
	this.name = name;
	this.age = age;
	this.adr = adr;
	this.birthday = birthday;
	this.photo = photo;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getPw() {
	return pw;
}

public void setPw(String pw) {
	this.pw = pw;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getAdr() {
	return adr;
}

public void setAdr(String adr) {
	this.adr = adr;
}

public Date getBirthday() {
	return birthday;
}

public void setBirthday(Date birthday) {
	this.birthday = birthday;
}

public String getPhoto() {
	return photo;
}

public void setPhoto(String photo) {
	this.photo = photo;
}
}

