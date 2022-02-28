package ru.diplom.diplom.client.services.entity;

import java.util.*;

public class Product {
    private Long id;
    private Long storeId;
    private int shelLife;
    private int countInStore;
    private Date produceDate;
    private String title;
    private String description;
    private double price;
    private String storeName;
    private Double storeDiscount;
    private Double personalDiscount;
    private Store store;
    private ProductLot productLot;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

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

    public int getShelLife() {
        return shelLife;
    }

    public Double getPersonalDiscount() {
        return personalDiscount;
    }

    public void setPersonalDiscount(Double personalDiscount) {
        this.personalDiscount = personalDiscount;
    }

    public void setShelLife(int shelLife) {
        this.shelLife = shelLife;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Product(String title, String description, Double price, Long storeId, int selfLife) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.storeId = storeId;
        this.shelLife = selfLife;
    }

    public int getCountInStore() {
        return countInStore;
    }

    public void setCountInStore(int countInStore) {
        this.countInStore = countInStore;
    }

    public Date getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
    }

    public ProductLot getProductLot() {
        return productLot;
    }

    public void setProductLot(ProductLot productLot) {
        this.productLot = productLot;
    }

    public Product() {
    }
}
