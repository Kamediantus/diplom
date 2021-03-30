package ru.rodichev.webBlog.entity;


import org.hibernate.annotations.Type;
import javax.persistence.*;

@Table(name = "t_thanks")
@Entity
public class Thanks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String person;
    private String links;
    @Type(type = "text")
    private String fullThanks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getFullThanks() {
        return fullThanks;
    }

    public void setFullThanks(String fullThanks) {
        this.fullThanks = fullThanks;
    }

    public Thanks(String person, String links, String fullThanks) {
        this.person = person;
        this.links = links;
        this.fullThanks = fullThanks;
    }

    public Thanks(){}
}
