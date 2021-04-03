package net.cnam.nfe107.domain.entity;

import net.cnam.nfe107.repository.model.OrderProductModel;

public class OrderProduct {

    private Order order;
    private Product product;
    private Long quantity;

    public OrderProduct() {
    }

    public OrderProduct(Order order, Product product, Long quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public OrderProduct(OrderProductModel orderProductModelUpdated) {
        this.order = new Order(orderProductModelUpdated.getOrder());
        this.product = new Product(orderProductModelUpdated.getProduct());
        this.quantity = orderProductModelUpdated.getQuantity();
    }

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public Product getProduct() {
        return product;
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
