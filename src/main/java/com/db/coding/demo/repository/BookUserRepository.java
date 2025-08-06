package com.db.coding.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.coding.demo.model.BookUser;
import com.db.coding.demo.model.BookUserId;

@Repository
public interface BookUserRepository extends JpaRepository<BookUser, BookUserId> {
    
    List<BookUser> findByBook_BookId(String bookId);
    
    List<BookUser> findByUser_UserId(String userId);
    
    boolean existsByBook_BookIdAndUser_UserId(String bookId, String userId);
}