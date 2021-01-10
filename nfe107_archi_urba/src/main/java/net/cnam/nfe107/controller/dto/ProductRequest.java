package net.cnam.nfe107.controller.dto;

import net.cnam.nfe107.domain.entity.Product;

public class ProductRequest {

    //Attributes

    private Long idProduct;
    private String name;
    private String description;
    private Float priceProduct;
    private Long stock;

//Constructors

    public ProductRequest(Long idProduct, String name, String description, Float priceProduct, Long stock) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.priceProduct = priceProduct;
        this.stock = stock;
    }

    public ProductRequest(Product product) {
        this.idProduct = product.getIdProduct();
        this.name = product.getName();
        this.description = product.getDescription();
        this.priceProduct = product.getPriceProduct();
        this.stock = product.getStock();

    }

    //Getters and Setters

    public Long getIdProduct() { return idProduct; }
    public void setIdProduct(Long idProduct) { this.idProduct = idProduct; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Float getPriceProduct() { return priceProduct; }
    public void setPriceProduct(Float priceProduct) { this.priceProduct = priceProduct; }
    public Long getStock() {
        return stock;
    }
    public void setStock(Long stock) {
        this.stock = stock;
    }
}
