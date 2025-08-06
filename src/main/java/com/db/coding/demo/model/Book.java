package com.db.coding.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@Column(name = "book_id", length = 20)
	private String bookId;

	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;

	@ManyToMany
	@JoinTable(name = "book_users", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> users = new HashSet<>();

	@OneToMany(mappedBy = "book")
	private Set<Trade> trades = new HashSet<>();

	public Book() {
	}

	public Book(String bookId, String name) {
		this.bookId = bookId;
		this.name = name;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Trade> getTrades() {
		return trades;
	}

	public void setTrades(Set<Trade> trades) {
		this.trades = trades;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", users=" + users + ", trades=" + trades + "]";
	}
	
	

}