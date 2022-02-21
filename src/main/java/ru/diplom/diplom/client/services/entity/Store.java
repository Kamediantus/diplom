package ru.diplom.diplom.client.services.entity;

public class Store {
    private Long id;
    private String title;
    private double discount;

    public Store(Long id, String title, double discount) {
        this.id = id;
        this.title = title;
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

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

    public Store(String title, Double discount) {
        this.title = title;
        this.discount = discount;
    }

    public Store() {
    }

}
