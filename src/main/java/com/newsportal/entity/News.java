package com.newsportal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "news")
@Entity
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

    @NotNull(message = "not null")
    @Size(min = 5, max = 100, message = "error size 5-100")
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @NotNull(message = "not null")
    @Size(min = 5, max = 10000, message = "error size min 5-10000")
    @Column(name = "content", nullable = false, length = 10000)
    private String content;

    @CreationTimestamp
    @Column(name = "date", nullable = false, updatable = false)
    private LocalDate date;

//    @PrePersist
//    public void onCreate() {
//        if (date == null) {
//            date = LocalDate.now();
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        News news = (News) o;
        return Objects.equals(id, news.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}