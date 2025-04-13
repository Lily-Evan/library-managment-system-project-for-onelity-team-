// src/main/java/com/library/service/BookService.java
package com.library.service;

import com.library.entity.Book;
import com.library.entity.User;
import com.library.repository.BookRepository;
import com.library.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    public List<Book> searchBooks(String query) {
        return bookRepository.findByTitleContainingOrAuthorContainingIgnoreCase(query, query);
    }
    
    @Transactional
    public Book borrowBook(Long bookId, User user) {
        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
            
        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is not available");
        }
        
        book.setAvailable(false);
        book.setBorrowedBy(user);
        book.setBorrowedAt(LocalDateTime.now());
        book.setDueDate(LocalDateTime.now().plusDays(14)); // 2 weeks loan period
        
        return bookRepository.save(book);
    }
    
    @Transactional
    public Book returnBook(Long bookId, User user) {
        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
            
        if (!user.equals(book.getBorrowedBy())) {
            throw new IllegalStateException("You can only return books you borrowed");
        }
        
        book.setAvailable(true);
        book.setBorrowedBy(null);
        book.setBorrowedAt(null);
        book.setDueDate(null);
        
        return bookRepository.save(book);
    }
}
