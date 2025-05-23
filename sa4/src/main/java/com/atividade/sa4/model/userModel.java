package com.atividade.sa4.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tab_user")
public class userModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    public userModel() {
    }
    public userModel(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
}
