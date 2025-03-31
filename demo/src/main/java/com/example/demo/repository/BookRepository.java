package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
    @Query("SELECT b FROM Book b WHERE b.name LIKE %?1% OR b.isbn LIKE %?1% OR b.serialName LIKE %?1%")
    List<Book> search(String keyword);
    
    boolean existsByIsbn(String isbn);  // Check if a book exists before inserting
}
