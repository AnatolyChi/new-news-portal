package com.newsportal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private Integer id;

    @NotNull(message = "not null")
    @Size(min = 3, max = 30, message = "error size login")
//    @Pattern(regexp = "^[A-Za-z]([.A-Za-z0-9-]{1,10})([A-Za-z0-9])$")
    @Column(name = "login", length = 30, unique = true, nullable = false)
    private String login;

    @NotNull(message = "not null")
    @Size(min = 5, max = 30, message = "error size password")
//    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{5,}")
    @Column(name = "password", length = 256, nullable = false)
    private String password;

    @Pattern(regexp = "^([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})$")
    @Column(name = "firstname", length = 30)
    private String firstname;

    @Pattern(regexp = "^([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})$")
    @Column(name = "lastname", length = 30)
    private String lastname;

    @Pattern(regexp = "^[^@]+@[^@.]+\\.[^@]+$")
    @Column(name = "email", length = 30)
    private String email;

//    @Pattern(regexp = "^(?:1(?:00?|\\d)|[2-5]\\d|[6-9]\\d?)$")
    @Column(name = "age")
    private Integer age;

    @Column(name = "date_registered", nullable = false)
    private Timestamp dateRegistered;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @PrePersist
    protected void onCreate() {
        if (dateRegistered == null) {
            dateRegistered = new Timestamp(System.currentTimeMillis());
        }

        if (role == null) {
            role = new Role();
            role.setId(2);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}