package com.example.ecommerce.entity;

import javax.persistence.*;

import java.util.List;


public class ProductDTO {
  private int id;

  private String productName;
  private double price;
  private int category;
  private String nameCategory;

  public ProductDTO() {
  }

  public ProductDTO(int id, String productName, double price, int category, String nameCategory) {
    this.id = id;
    this.productName = productName;
    this.price = price;
    this.category = category;
    this.nameCategory = nameCategory;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNameCategory() {
    return nameCategory;
  }

  public void setNameCategory(String nameCategory) {
    this.nameCategory = nameCategory;
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

  public int getCategory() {
    return category;
  }

  public void setCategory(int category) {
    this.category = category;
  }
}