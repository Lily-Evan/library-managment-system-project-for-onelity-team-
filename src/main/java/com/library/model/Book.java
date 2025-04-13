// src/main/java/com/library/model/Book.java
package com.library.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String author;
    private boolean available = true;
    
    @ManyToOne
    @JoinColumn(name = "borrowed_by_id")
    private User borrowedBy;
}

