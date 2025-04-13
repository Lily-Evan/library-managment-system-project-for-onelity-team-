// src/main/java/com/library/controller/BookController.java
package com.library.controller;

import com.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    
    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    
    @GetMapping("/search")
    public ResponseEntity<?> searchBooks(@RequestParam String query) {
        return ResponseEntity.ok(bookService.searchBooks(query));
    }
    
    @PostMapping("/{id}/borrow")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> borrowBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.borrowBook(id, getCurrentUser()));
    }
    
    @PostMapping("/{id}/return")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> returnBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.returnBook(id, getCurrentUser()));
    }
}

// src/main/java/com/library/controller/AdminController.java
package com.library.controller;

import com.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/books")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    private final BookService bookService;
    
    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody @Valid Book book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody @Valid Book book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
