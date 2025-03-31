package com.example.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.entity.Book;

public interface BookService {

    List<Book> findAllBooks();

    List<Book> searchBooks(String keyword);

    Book findBookById(Long id);

    void createBook(Book book);

    void updateBook(Book book);

    void deleteBook(Long id);

    Page<Book> findPaginated(Pageable pageable);
    
    boolean existsByIsbn(String isbn); // New method to prevent duplicate books
}
