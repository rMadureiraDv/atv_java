package com.atividade.sa4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tab_user")
public class userModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome é obrigatório")
    @Column (nullable = false)
    private String name;
    @NotBlank(message = "Email é obrigatório")
    @Column (nullable = false,unique = true)
    private String email;
    @NotBlank(message = "Data de Nascimento é obrigatória")
    @Column (nullable = false)
    private String dataNascimento;
    public userModel() {
    }
    public userModel(Long id, String name, String email, String dataNascimento) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
     
}
