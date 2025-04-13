// src/main/java/com/library/repository/UserRepository.java
package com.library.repository;

import com.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

// src/main/java/com/library/repository/BookRepository.java
package com.library.repository;

import com.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingOrAuthorContaining(String title, String author);
}
