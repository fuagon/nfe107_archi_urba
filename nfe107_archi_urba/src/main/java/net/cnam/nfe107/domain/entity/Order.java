package net.cnam.nfe107.domain.entity;

import com.sun.istack.Nullable;
import net.cnam.nfe107.controller.dto.OrderRequest;
import net.cnam.nfe107.repository.model.OrderModel;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long idOrder;
    private String date;
    private Float price;
    private Address address;
    private Customer customer;
    private OrderStatus orderStatus;

    public Order() {
    }

    public Order(Long idOrder, String date, Float price) {
        this.idOrder = idOrder;
        this.date = date;
        this.price = price;
    }

    public Order(OrderModel orderModel) {
        this.idOrder = orderModel.getIdOrder();
        this.date = orderModel.getDate();
        this.price = orderModel.getPrice();
        this.customer = new Customer(orderModel.getCustomer());
        this.address = new Address(orderModel.getAddress());
        this.orderStatus = new OrderStatus(orderModel.getOrderStatus());
    }

    public Order(OrderRequest orderRequest) {
        this.idOrder = orderRequest.getIdOrder();
        this.date = orderRequest.getDate();
        this.price = orderRequest.getPrice();
    }

    public Order(OrderRequest orderRequest, Customer customer, Address address, OrderStatus orderStatus) {
        this.idOrder = orderRequest.getIdOrder();
        this.date = orderRequest.getDate();
        this.price = orderRequest.getPrice();
        this.customer = customer;
        this.address = address;
        this.orderStatus = orderStatus;
    }

    public Order(OrderModel orderModel, Customer customer, Address address, OrderStatus orderStatus) {
        this.idOrder = orderModel.getIdOrder();
        this.date = orderModel.getDate();
        this.price = orderModel.getPrice();
        this.customer = customer;
        this.address = address;
        this.orderStatus = orderStatus;
    }

    public Order(OrderModel orderModel, Customer customer) {
        this.idOrder = orderModel.getIdOrder();
        this.date = orderModel.getDate();
        this.price = orderModel.getPrice();
        this.customer = customer;
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
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
