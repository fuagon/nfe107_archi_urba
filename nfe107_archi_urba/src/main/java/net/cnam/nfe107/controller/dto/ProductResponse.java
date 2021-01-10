package net.cnam.nfe107.controller.dto;

import net.cnam.nfe107.domain.entity.Product;
import net.cnam.nfe107.repository.model.ProductModel;

public class ProductResponse {

    //Attributes

    private Long idProduct;
    private String name;
    private String description;
    private Float priceProduct;
    private Long stock;

//Constructors

    public ProductResponse(Long idProduct, String name, String description, Float priceProduct, Long stock) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.priceProduct = priceProduct;
        this.stock = stock;
    }

    public ProductResponse(Product productResponse) {
        this.idProduct = productResponse.getIdProduct();
        this.name = productResponse.getName();
        this.description = productResponse.getDescription();
        this.priceProduct = productResponse.getPriceProduct();
        this.stock = productResponse.getStock();
    }

    public ProductResponse(ProductModel productModel) {
        this.idProduct = productModel.getIdProduct();
        this.name = productModel.getName();
        this.description = productModel.getDescription();
        this.priceProduct = productModel.getPriceProduct();
        this.stock = productModel.getStock();
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
