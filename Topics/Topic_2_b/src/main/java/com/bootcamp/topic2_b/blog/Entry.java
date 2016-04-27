package com.bootcamp.topic2_b.blog;

import java.util.Date;

public class Entry {
	private int id;
	private Date date;
	private String title;
	private String body;
	private String author;
	private static int lastId;
	
	public Entry (Date date, String title, String author, String body){
		this.id = lastId++;
		this.date=date;
		this.title=title;
		this.author = author;
		this.body = body;
	}

	public Date getDate() {
		return date;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public String getAuthor() {
		return author;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Entry [id=" + id + ", date=" + date + ", title=" + title + ", body=" + body + ", author=" + author + "]";
	}

}
