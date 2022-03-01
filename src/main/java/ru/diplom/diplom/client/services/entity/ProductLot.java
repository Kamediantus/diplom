package ru.diplom.diplom.client.services.entity;

import java.util.*;

public class ProductLot {
    private Long id;
    private Long productId;
    private Long storeId;
    private Date dateOfProduction;
    private int shelLife;
    private int count;
    private boolean fresh;

    public ProductLot(Long id, Long productId, Long storeId, Date dateOfProduction, int shelLife, int count) {
        this.id = id;
        this.productId = productId;
        this.storeId = storeId;
        this.dateOfProduction = dateOfProduction;
        this.shelLife = shelLife;
        this.count = count;
    }

    public ProductLot(Boolean isFresh) {
        this.fresh = isFresh;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Date getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(Date dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    public int getShelLife() {
        return shelLife;
    }

    public void setShelLife(int shelLife) {
        this.shelLife = shelLife;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isFresh() {
        return fresh;
    }

    public void setFresh(boolean fresh) {
        this.fresh = fresh;
    }
}
