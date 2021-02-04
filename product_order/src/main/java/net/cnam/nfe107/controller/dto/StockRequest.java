package net.cnam.nfe107.controller.dto;

import net.cnam.nfe107.domain.entity.Product;

public class StockRequest {

    //Attributes

    private Long idProduct;
    private Long stock;

    //Constructors

    public StockRequest(Long idProduct, Long stock) {
        this.idProduct = idProduct;
        this.stock = stock;
    }

    //Getters and Setters

    public Long getIdProduct() { return idProduct; }
    public void setIdProduct(Long idProduct) { this.idProduct = idProduct; }
    public Long getStock() {
        return stock;
    }
    public void setStock(Long stock) {
        this.stock = stock;
    }
}
