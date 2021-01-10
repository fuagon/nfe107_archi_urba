package net.cnam.nfe107.domain.entity;

import net.cnam.nfe107.controller.dto.ProductRequest;
import net.cnam.nfe107.repository.model.ProductModel;

public class ProductToCreate {

    private String name;
    private String description;
    private Float priceProduct;
    private Long stock;

    public ProductToCreate(String name, String description, Float priceProduct, Long stock) {
        this.name = name;
        this.description = description;
        this.priceProduct = priceProduct;
        this.stock = stock;
    }

    public ProductToCreate(ProductModel productModel) {
        this.name = productModel.getName();
        this.description = productModel.getDescription();
        this.priceProduct = productModel.getPriceProduct();
        this.stock = productModel.getStock();
    }

    public ProductToCreate(ProductRequest productRequest) {
        this.name = productRequest.getName();
        this.description = productRequest.getDescription();
        this.priceProduct = productRequest.getPriceProduct();
        this.stock = productRequest.getStock();
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
    public Float getPriceProduct() {
        return priceProduct;
    }
    public void setPriceProduct(Float priceProduct) {
        this.priceProduct = priceProduct;
    }
    public Long getStock() {
        return stock;
    }
    public void setStock(Long stock) {
        this.stock = stock;
    }
}