// src/main/java/com/library/entity/Book.java
package com.library.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String title;
    
    @NotBlank
    private String author;
    
    private boolean available = true;
    
    @ManyToOne
    private User borrowedBy;
    
    private LocalDateTime borrowedAt;
    
    private LocalDateTime dueDate;
}

