package net.cnam.nfe107.domain.entity;

import com.sun.istack.Nullable;
import net.cnam.nfe107.controller.dto.OrderRequest;
import net.cnam.nfe107.repository.model.OrderModel;
import net.cnam.nfe107.repository.model.OrderProductModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Order {

    private Long idOrder;
    private String date;
    private Float priceOrder;
    private Address address;
    private Customer customer;
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
        this.customer = new Customer(orderModel.getCustomer());
        this.address = new Address(orderModel.getAddress());
        this.orderStatus = new OrderStatus(orderModel.getOrderStatus());
        this.orderProducts = orderModel.getOrdersProducts();
    }

    public Order(OrderRequest orderRequest) {
        this.idOrder = orderRequest.getIdOrder();
        this.date = orderRequest.getDate();
        this.priceOrder = orderRequest.getPriceOrder();
    }

    public Order(OrderRequest orderRequest, Customer customer, Address address, OrderStatus orderStatus) {
        this.idOrder = orderRequest.getIdOrder();
        this.date = orderRequest.getDate();
        this.priceOrder = orderRequest.getPriceOrder();
        this.customer = customer;
        this.address = address;
        this.orderStatus = orderStatus;
    }

    public Order(OrderModel orderModel, Customer customer, Address address, OrderStatus orderStatus) {
        this.idOrder = orderModel.getIdOrder();
        this.date = orderModel.getDate();
        this.priceOrder = orderModel.getPriceOrder();
        this.customer = customer;
        this.address = address;
        this.orderStatus = orderStatus;
        this.orderProducts = orderModel.getOrdersProducts();
    }

    public Order(OrderModel orderModel, Customer customer) {
        this.idOrder = orderModel.getIdOrder();
        this.date = orderModel.getDate();
        this.priceOrder = orderModel.getPriceOrder();
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
    public Float getPriceOrder() {
        return priceOrder;
    }
    public void setPriceOrder(Float priceOrder) {
        this.priceOrder = priceOrder;
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
    public Set<OrderProductModel> getOrderProducts() {
        return orderProducts;
    }
    public void setOrderProducts(Set<OrderProductModel> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
