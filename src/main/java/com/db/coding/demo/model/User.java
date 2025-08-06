package com.db.coding.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "user_id", length = 20)
	private String userId;

	@Column(name = "username", length = 50, nullable = false)
	private String username;

	@Column(name = "email", length = 100, nullable = false, unique = true)
	private String email;

	@Column(name = "role", length = 20, nullable = false)
	private String role;

	@ManyToMany(mappedBy = "users")
	private Set<Book> books = new HashSet<>();

	public User() {
	}

	public User(String userId, String username, String email, String role) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", role=" + role + ", books="
				+ books + "]";
	}

}