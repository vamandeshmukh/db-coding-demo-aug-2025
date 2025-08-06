package com.db.coding.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.db.coding.demo.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    
    Book findByName(String name);
    
    List<Book> findByNameContainingIgnoreCase(String namePart);
    
    @Query("SELECT b FROM Book b JOIN b.users u WHERE u.userId = :userId")
    List<Book> findBooksByUserId(String userId);
    
    Long countByNameLike(String namePattern);
}