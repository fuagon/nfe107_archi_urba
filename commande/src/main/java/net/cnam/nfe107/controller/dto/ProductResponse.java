package net.cnam.nfe107.controller.dto;

import net.cnam.nfe107.domain.entity.Product;

public class ProductResponse {
    private Long idProduct;
    private String name;
    private String description;
    private Float priceProduct;
    private Long quantity;

    public ProductResponse(Long idProduct, String name, String description, Float priceProduct, Long quantity) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.priceProduct = priceProduct;
        this.quantity = quantity;
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

    public Float getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Float priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
