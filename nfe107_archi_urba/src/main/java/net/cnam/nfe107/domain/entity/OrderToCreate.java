package net.cnam.nfe107.domain.entity;

import net.cnam.nfe107.controller.dto.OrderRequest;
import net.cnam.nfe107.repository.model.OrderModel;

public class OrderToCreate {

    private String date;
    private Float price;
    private Customer customer;
    private Address address;
    private OrderStatus orderStatus;

    public OrderToCreate(String date, Float price) {
        this.date = date;
        this.price = price;
    }

    public OrderToCreate(OrderModel orderModel) {
        this.date = orderModel.getDate();
        this.price = orderModel.getPrice();
    }

    public OrderToCreate(OrderRequest orderRequest) {
        this.date = orderRequest.getDate();
        this.price = orderRequest.getPrice();
    }

    public OrderToCreate(OrderRequest orderRequest, Customer customer, Address address, OrderStatus orderStatus) {
        this.date = orderRequest.getDate();
        this.price = orderRequest.getPrice();
        this.customer = customer;
        this.address = address;
        this.orderStatus = orderStatus;
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
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
