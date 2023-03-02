package com.bit.bbs.model;

import java.util.Date;

public class BbsDto {
	private int num;
	private String id,title,contents;
	private Date date;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String content) {
		this.contents = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "{\"num\":" + num + ", \"id\":'" + id + "', \"title\":'" + title + "', \"contents\":'" + contents + "', \"date\":'" + date
				+ "'}";
	}
}
