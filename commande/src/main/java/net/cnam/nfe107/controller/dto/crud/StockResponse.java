package net.cnam.nfe107.controller.dto.crud;

import net.cnam.nfe107.domain.entity.Product;
import net.cnam.nfe107.repository.model.ProductModel;

public class StockResponse {

    //Attributes

    private Long idProduct;
    private Long stock;

//Constructors

    public StockResponse(Long idProduct, Long stock) {
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
