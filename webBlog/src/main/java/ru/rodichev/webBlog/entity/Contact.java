package ru.rodichev.webBlog.entity;


import org.hibernate.annotations.Type;
import org.springframework.core.codec.StringDecoder;

import javax.persistence.*;

@Table(name = "t_contact")
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String link;
    private String visibleTextOfLink;
    private String description;
    private String isVisible;

    public Contact() {
    }

    public Contact(String name, String link, String visibleTextOfLink, String description, String isVisible) {
        this.name = name;
        this.link = link;
        this.visibleTextOfLink = visibleTextOfLink;
        if (description != null) this.description = description;
        this.isVisible = isVisible;
    }

    public void update(String name, String link, String visibleTextOfLink, String description, String isVisible) {
        this.setName(name);
        this.setLink(link);
        this.setVisibleTextOfLink(visibleTextOfLink);
        this.setDescription(description);
        this.setIsVisible(isVisible);
    }

    public String getVisibleTextOfLink() {
        return visibleTextOfLink;
    }

    public void setVisibleTextOfLink(String visibleTextOfLink) {
        this.visibleTextOfLink = visibleTextOfLink;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(String isVisible) {
        this.isVisible = isVisible;
    }
}
