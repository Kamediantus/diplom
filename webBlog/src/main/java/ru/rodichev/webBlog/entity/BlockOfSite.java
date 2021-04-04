package ru.rodichev.webBlog.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Table(name = "t_main_info")
@Entity
public class BlockOfSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Type(type = "text")
    private String fullText;
    @Type(type = "text")
    private String previousFullText;

    public BlockOfSite() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public String getPreviousFullText() {
        return previousFullText;
    }

    public void setPreviousFullText(String previousFullText) {
        this.previousFullText = previousFullText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
