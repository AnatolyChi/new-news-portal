package com.newsportal.entity;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "login", length = 30)
    private String login;

    @Column(name = "password", length = 256)
    private String password;

    @Column(name = "firstname", length = 30)
    private String firstname;

    @Column(name = "lastname", length = 30)
    private String lastname;

    @Column(name = "email", length = 30)
    private String email;

    @Column(name = "age")
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "date_registered")
    private Instant dateRegistered;

    public Instant getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Instant dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}