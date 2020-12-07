package net.cnam.nfe107.controller.dto;

import net.cnam.nfe107.domain.OrderProductService;
import net.cnam.nfe107.domain.entity.Order;
import net.cnam.nfe107.domain.entity.OrderProduct;
import net.cnam.nfe107.domain.entity.Product;

public class OrderProductResponse {

    private Order order;
    private Product product;
    private Long quantity;

    public OrderProductResponse() {
    }

    public OrderProductResponse(Order order, Product product, Long quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public OrderProductResponse(OrderProduct orderProduct)
    {
        this.order = orderProduct.getOrder();
        this.product = orderProduct.getProduct();
        this.quantity = orderProduct.getQuantity();
    }

    public Long getIdOrder() {
        return order.getIdOrder();
    }
    public void setOrder(Order idOrder) {
        this.order = order;
    }
    public Long getIdProduct() {
        return product.getIdProduct();
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Long getQuantity() {
        return quantity;
    }
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
