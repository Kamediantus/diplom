package ru.diplom.diplom.client.services.entity;

public class Product {
    private Long id;
    private Long storeId;
    private String title;
    private String description;
    private double price;
    private String storeName;
    private Double storeDiscount;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Double getStoreDiscount() {
        return storeDiscount;
    }

    public void setStoreDiscount(Double storeDiscount) {
        this.storeDiscount = storeDiscount;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public String getStringPrice() {
        return Double.toString(this.price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Product(String title, String description, Double price, Long storeId) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.storeId = storeId;
    }

    public Product() {
    }
}
