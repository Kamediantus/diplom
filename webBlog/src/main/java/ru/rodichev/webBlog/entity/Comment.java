package ru.rodichev.webBlog.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/***
 * Class of comment to useful displaying
 */
@Table(name = "t_comment")
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postId;
    private String author;
    @Type(type = "text")
    private String fullComment;
    private String date;

    public Comment(Long postId, String author, String fullComment, String date) {
        this.postId = postId;
        this.author = author;
        this.fullComment = fullComment;
        this.date = date;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFullComment() {
        return fullComment;
    }

    public void setFullComment(String fullComment) {
        this.fullComment = fullComment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
