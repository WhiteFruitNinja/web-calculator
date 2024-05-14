package com.spring.calculator.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Number> numbers;

    @Column(name = "username")
    private String username;

    @Column(name = "role")
    private String role;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Transient
    private String passwordConfirm;

    public User(int id, String username, String role, String email, String password, String passwordConfirm) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    public User(String username, String role, String email, String password, String passwordConfirm) {
        this.username = username;
        this.role = role;
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public void setAuthorities(String role) {
        this.role = role;
    }

    public String getAuthorities() {
        return role;
    }
}
