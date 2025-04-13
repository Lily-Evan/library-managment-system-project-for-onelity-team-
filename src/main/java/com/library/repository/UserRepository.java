// src/main/java/com/library/repository/UserRepository.java
package com.library.repository;

import com.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}

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
