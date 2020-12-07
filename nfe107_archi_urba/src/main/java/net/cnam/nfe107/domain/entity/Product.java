package net.cnam.nfe107.domain.entity;

import net.cnam.nfe107.controller.dto.ProductRequest;
import net.cnam.nfe107.repository.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private Long idProduct;
    private String name;
    private String description;
    private Float price;
    private Long stock;

    public Product(Long idProduct, String name, String description, Float price, Long stock) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Product(ProductModel productModel) {
        this.idProduct = productModel.getIdProduct();
        this.name = productModel.getName();
        this.description = productModel.getDescription();
        this.price = productModel.getPrice();
        this.stock = productModel.getStock();
    }

    public Product(ProductRequest productRequest) {
        this.idProduct = productRequest.getIdProduct();
        this.name = productRequest.getName();
        this.description = productRequest.getDescription();
        this.price = productRequest.getPrice();
        this.stock = productRequest.getStock();
    }

    public Long getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
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
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public Long getStock() {
        return stock;
    }
    public void setStock(Long stock) {
        this.stock = stock;
    }
}