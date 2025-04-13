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


