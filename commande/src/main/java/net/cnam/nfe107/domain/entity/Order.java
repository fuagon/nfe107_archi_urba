package net.cnam.nfe107.domain.entity;

import net.cnam.nfe107.controller.dto.crud.OrderRequest;
import net.cnam.nfe107.repository.model.OrderModel;
import net.cnam.nfe107.repository.model.OrderProductModel;

import java.util.Set;

public class Order {

    private Long idOrder;
    private String date;
    private Float priceOrder;
    private Long idAddress;
    private Long idCustomer;
    private OrderStatus orderStatus;
    private Set<OrderProductModel> orderProducts;

    public Order() {
    }

    public Order(Long idOrder, String date, Float priceOrder) {
        this.idOrder = idOrder;
        this.date = date;
        this.priceOrder = priceOrder;
    }

    public Order(OrderModel orderModel) {
        this.idOrder = orderModel.getIdOrder();
        this.date = orderModel.getDate();
        this.priceOrder = orderModel.getPriceOrder();
        this.idCustomer = orderModel.getIdCustomer();
        this.idAddress = orderModel.getIdAddress();
        this.orderStatus = new OrderStatus(orderModel.getOrderStatus());
        this.orderProducts = orderModel.getOrdersProducts();
    }

    public Order(OrderRequest orderRequest) {
        this.idOrder = orderRequest.getIdOrder();
        this.date = orderRequest.getDate();
        this.priceOrder = orderRequest.getPriceOrder();
    }

    public Order(OrderRequest orderRequest, OrderStatus orderStatus) {
        this.idOrder = orderRequest.getIdOrder();
        this.date = orderRequest.getDate();
        this.priceOrder = orderRequest.getPriceOrder();
        this.idCustomer = orderRequest.getIdCustomer();
        this.idAddress = orderRequest.getIdAddress();
        this.orderStatus = orderStatus;
    }

    public Order(OrderModel orderModel, OrderStatus orderStatus) {
        this.idOrder = orderModel.getIdOrder();
        this.date = orderModel.getDate();
        this.priceOrder = orderModel.getPriceOrder();
        this.idCustomer = orderModel.getIdCustomer();
        this.idAddress = orderModel.getIdAddress();
        this.orderStatus = orderStatus;
        this.orderProducts = orderModel.getOrdersProducts();
    }

    public Long getIdOrder() {
        return idOrder;
    }
    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Float getPriceOrder() {
        return priceOrder;
    }
    public void setPriceOrder(Float priceOrder) {
        this.priceOrder = priceOrder;
    }
    public Long getIdCustomer() {
        return idCustomer;
    }
    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }
    public Long getIdAddress() {
        return idAddress;
    }
    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Set<OrderProductModel> getOrderProducts() {
        return orderProducts;
    }
    public void setOrderProducts(Set<OrderProductModel> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
