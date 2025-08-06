package com.db.coding.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book_users")
@IdClass(BookUserId.class)
public class BookUser {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	@Id
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public BookUser() {
	}

	public BookUser(Book book, User user) {
		this.book = book;
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BookUser [book=" + book + ", user=" + user + "]";
	}

}