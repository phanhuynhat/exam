package com.example.ecommerce.dto;


import javax.persistence.TupleElement;
import java.util.List;

public class ProductDTONew {

    private int id;

    private String productName;

    private double price;

    private String categoryName;

    public ProductDTONew() {
    }

    public ProductDTONew(int id, String productName, double price, String categoryName) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.categoryName = categoryName;
    }

    public ProductDTONew(List<TupleElement<?>> elements) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}