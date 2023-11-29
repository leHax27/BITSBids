package com.bitsbids.demo.entities;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private String id;

    @Column(columnDefinition = "VARCHAR(255)")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "bid_price", columnDefinition = "DECIMAL(10,2)")
    private Double bidPrice;

    @Column(name = "base_price", columnDefinition = "DECIMAL(10,2)")
    private Double basePrice;

    @Column(name = "image_key", columnDefinition = "VARCHAR(255)")
    private String imageKey;

    // Default constructor
    public Product() {
        // Default constructor is needed by JPA
    }

    // Parameterized constructor
    public Product(String name, String description, Double bidPrice, Double basePrice, String imageKey) {
        this.name = name;
        this.description = description;
        this.bidPrice = bidPrice;
        this.basePrice = basePrice;
        this.imageKey = imageKey;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public String getImageKey() {
        return imageKey;
    }

    public void setImageKey(String imageKey) {
        this.imageKey = imageKey;
    }
}
