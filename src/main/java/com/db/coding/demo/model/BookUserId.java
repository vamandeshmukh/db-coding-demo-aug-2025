package com.db.coding.demo.model;

import java.io.Serializable;

public class BookUserId implements Serializable {

	private static final long serialVersionUID = 1L;

	private String book;
	private String user;

	
	public BookUserId() {
	}

	public BookUserId(String book, String user) {
		this.book = book;
		this.user = user;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BookUserId [book=" + book + ", user=" + user + "]";
	}
	
	

}