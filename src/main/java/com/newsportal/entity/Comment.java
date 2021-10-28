package com.newsportal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "comment")
@Entity
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    private Integer commentId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "news_id", nullable = false)
    private News news;

    @NotNull(message = "{user.valid.notnull}")
    @Column(name = "content", nullable = false)
    private String contentComment;

    @CreationTimestamp
    @Column(name = "date", nullable = false, updatable = false)
    private Timestamp date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Comment comment = (Comment) o;
        return commentId != null && Objects.equals(commentId, comment.commentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId);
    }
}
