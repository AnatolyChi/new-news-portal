package com.newsportal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "user")
@Entity
public class User implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @NotNull(message = "{user.valid.notnull}")
    @Size(min = 3, max = 30, message = "{user.valid.username}")
//    @Pattern(regexp = "^[A-Za-z]([.A-Za-z0-9-]{1,10})([A-Za-z0-9])$")
    @Column(name = "username", length = 30, nullable = false)
    private String username;

    @NotNull(message = "{user.valid.notnull}")
    @Size(min = 5, max = 30, message = "{user.valid.password}")
//    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{5,}")
    @Column(name = "password", length = 256, nullable = false)
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @Pattern(regexp = "^([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})$", message = "{user.valid.firstname}")
    @Column(name = "firstname", length = 30)
    private String firstname;

//    @Pattern(regexp = "^([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})$", message = "{user.valid.lastname}")
    @Column(name = "lastname", length = 30)
    private String lastname;

//    @Email(message = "{user.valid.email}")
    @Column(name = "email", length = 30)
    private String email;

//    @Min(value = 18, message = "{user.valid.age}")
    @Column(name = "age")
    private Integer age;

    @CreationTimestamp
    @Column(name = "date_registered", nullable = false, updatable = false)
    private Timestamp dateRegistered;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @ToString.Exclude
    private Set<Role> userRole;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "favorite_news",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "news_id")
    )
    @ToString.Exclude
    private Set<News> favouriteNews;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getUserRole();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}