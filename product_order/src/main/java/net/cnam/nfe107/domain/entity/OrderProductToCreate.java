package net.cnam.nfe107.domain.entity;

import net.cnam.nfe107.controller.dto.OrderProductRequest;

public class OrderProductToCreate {

    private Long idOrder;
    private Long idProduct;
    private Long quantity;

    public OrderProductToCreate() {
    }

    public OrderProductToCreate(Long idOrder, Long idProduct, Long quantity) {
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public OrderProductToCreate(OrderProductRequest orderProductRequest)
    {
        this.idOrder = orderProductRequest.getIdOrder();
        this.idProduct = orderProductRequest.getIdProduct();
        this.quantity = orderProductRequest.getQuantity();
    }

    public Long getIdOrder() {
        return idOrder;
    }
    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }
    public Long getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }
    public Long getQuantity() {
        return quantity;
    }
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}