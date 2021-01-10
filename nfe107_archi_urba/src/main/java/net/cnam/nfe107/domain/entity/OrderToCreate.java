package net.cnam.nfe107.domain.entity;

import net.cnam.nfe107.controller.dto.AddProductToOrderRequest;
import net.cnam.nfe107.controller.dto.OrderRequest;
import net.cnam.nfe107.repository.model.OrderModel;

public class OrderToCreate {

    private String date;
    private Float priceOrder;
    private Customer customer;
    private Address address;
    private OrderStatus orderStatus;

    public OrderToCreate(String date, Float priceOrder) {
        this.date = date;
        this.priceOrder = priceOrder;
    }

    public OrderToCreate(OrderModel orderModel) {
        this.date = orderModel.getDate();
        this.priceOrder = orderModel.getPriceOrder();
    }

    public OrderToCreate(OrderRequest orderRequest) {
        this.date = orderRequest.getDate();
        this.priceOrder = orderRequest.getPriceOrder();
    }

    public OrderToCreate(OrderRequest orderRequest, Customer customer, Address address, OrderStatus orderStatus) {
        this.date = orderRequest.getDate();
        this.priceOrder = orderRequest.getPriceOrder();
        this.customer = customer;
        this.address = address;
        this.orderStatus = orderStatus;
    }

    public OrderToCreate(AddProductToOrderRequest addProductToOrderRequest, Customer customer, Address address, OrderStatus orderStatus)
    {
        this.date = addProductToOrderRequest.getDate();
        this.priceOrder = addProductToOrderRequest.getPriceOrder();
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
    public Float getPriceOrder() {
        return priceOrder;
    }
    public void setPriceOrder(Float priceOrder) {
        this.priceOrder = priceOrder;
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
