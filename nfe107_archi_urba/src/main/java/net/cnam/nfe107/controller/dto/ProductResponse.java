package net.cnam.nfe107.controller.dto;

import net.cnam.nfe107.domain.entity.Product;
import net.cnam.nfe107.repository.model.ProductModel;

public class ProductResponse {

    //Attributes

    private Long idProduct;
    private String name;
    private String description;
    private Float price;
    private Long stock;

//Constructors

    public ProductResponse(Long idProduct, String name, String description, Float price, Long stock) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public ProductResponse(Product productResponse) {
        this.idProduct = productResponse.getIdProduct();
        this.name = productResponse.getName();
        this.description = productResponse.getDescription();
        this.price = productResponse.getPrice();
        this.stock = productResponse.getStock();
    }

    public ProductResponse(ProductModel productModel) {
        this.idProduct = productModel.getIdProduct();
        this.name = productModel.getName();
        this.description = productModel.getDescription();
        this.price = productModel.getPrice();
        this.stock = productModel.getStock();
    }

    //Getters and Setters

    public Long getIdProduct() { return idProduct; }
    public void setIdProduct(Long idProduct) { this.idProduct = idProduct; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Float getPrice() { return price; }
    public void setPrice(Float price) { this.price = price; }
    public Long getStock() {
        return stock;
    }
    public void setStock(Long stock) {
        this.stock = stock;
    }
}
