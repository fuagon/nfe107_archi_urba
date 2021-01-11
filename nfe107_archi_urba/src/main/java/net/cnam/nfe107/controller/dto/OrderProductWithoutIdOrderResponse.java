package net.cnam.nfe107.controller.dto;

import net.cnam.nfe107.domain.entity.Order;
import net.cnam.nfe107.domain.entity.OrderProduct;
import net.cnam.nfe107.domain.entity.Product;

public class OrderProductWithoutIdOrderResponse {

    private Order order;
    private Product product;
    private Long quantity;

    public OrderProductWithoutIdOrderResponse() {
    }

    public OrderProductWithoutIdOrderResponse(Order order, Product product, Long quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public OrderProductWithoutIdOrderResponse(OrderProduct orderProduct)
    {
        this.order = orderProduct.getOrder();
        this.product = orderProduct.getProduct();
        this.quantity = orderProduct.getQuantity();
    }

    public void setOrder(Order Order) {
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
