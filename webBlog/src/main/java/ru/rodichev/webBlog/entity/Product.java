package ru.rodichev.webBlog.entity;

import org.hibernate.annotations.Type;
import javax.persistence.*;

@Table(name = "t_notes")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Product(String title, String description, Double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Product() {
    }
}

