// src/main/java/com/library/model/User.java
package com.library.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String email;
    
    private String password;
    private String name;
    
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;
}

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

// src/main/java/com/library/model/Role.java
package com.library.model;

public enum Role {
    USER, ADMIN
}
