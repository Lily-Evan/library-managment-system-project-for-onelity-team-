// src/main/java/com/library/repository/BookRepository.java
package com.library.repository;

import com.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingOrAuthorContainingIgnoreCase(String title, String author);
    List<Book> findByAvailable(boolean available);
    List<Book> findByBorrowedById(Long userId);
}
