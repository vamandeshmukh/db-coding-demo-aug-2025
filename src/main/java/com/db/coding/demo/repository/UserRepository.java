package com.db.coding.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.db.coding.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	User findByUsername(String username);

	List<User> findByRole(String role);

	List<User> findByEmailContainingIgnoreCase(String emailPart);

	@Query("SELECT u FROM User u JOIN u.books b WHERE b.bookId = :bookId")
	List<User> findUsersByBookId(String bookId);
}