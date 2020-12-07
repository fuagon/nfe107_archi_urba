package net.cnam.nfe107.controller.dto;

import net.cnam.nfe107.domain.entity.*;
import net.cnam.nfe107.repository.model.OrderModel;
import net.cnam.nfe107.repository.model.OrderStatusModel;

import java.util.ArrayList;

public class OrderResponse {

    //Attributes

    private Long idOrder;
    private String date;
    private Float price;
    private Customer customer;
    private Address address;
    private OrderStatus orderStatus;

    //Constructors

    public OrderResponse() {
    }

    public OrderResponse(Long idOrder, String date, Float price) {
        this.idOrder = idOrder;
        this.date = date;
        this.price = price;
    }

    public OrderResponse(Order order) {
        this.idOrder = order.getIdOrder();
        this.date = order.getDate();
        this.price = order.getPrice();
        this.customer = order.getCustomer();
        this.address = order.getAddress();
        this.orderStatus = order.getOrderStatus();
    }

    public OrderResponse(OrderModel orderModel) {
        this.idOrder = orderModel.getIdOrder();
        this.date = orderModel.getDate();
        this.price = orderModel.getPrice();
    }

    public OrderResponse(Order order, Customer customer, Address address, OrderStatus orderStatus) {
        this.idOrder = order.getIdOrder();
        this.date = order.getDate();
        this.price = order.getPrice();
        this.customer = customer;
        this.address = address;
        this.orderStatus = orderStatus;
    }

    //Getters and Setters

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
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public Long getIdCustomer() { return customer.getIdCustomer(); }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public Long getIdAddress() {
        return address.getIdAddress();
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Long getIdOrderStatus() {
        return orderStatus.getIdOrderStatus();
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}