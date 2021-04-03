package net.cnam.nfe107.controller.dto.crud;

import net.cnam.nfe107.domain.entity.*;
import net.cnam.nfe107.repository.model.OrderModel;
import net.cnam.nfe107.repository.model.OrderStatusModel;

import java.util.ArrayList;

public class OrderResponse {

    //Attributes

    private Long idOrder;
    private String date;
    private Float priceOrder;
    private Long idCustomer;
    private Long idAddress;
    private OrderStatus orderStatus;

    //Constructors

    public OrderResponse() {
    }

    public OrderResponse(Long idOrder, String date, Float priceOrder) {
        this.idOrder = idOrder;
        this.date = date;
        this.priceOrder = priceOrder;
    }

    public OrderResponse(Order order) {
        this.idOrder = order.getIdOrder();
        this.date = order.getDate();
        this.priceOrder = order.getPriceOrder();
        this.idCustomer = order.getIdCustomer();
        this.idAddress = order.getIdAddress();
        this.orderStatus = order.getOrderStatus();
    }

    public OrderResponse(OrderModel orderModel) {
        this.idOrder = orderModel.getIdOrder();
        this.date = orderModel.getDate();
        this.priceOrder = orderModel.getPriceOrder();
    }

    public OrderResponse(Order order, OrderStatus orderStatus) {
        this.idOrder = order.getIdOrder();
        this.date = order.getDate();
        this.priceOrder = order.getPriceOrder();
        this.idCustomer = order.getIdCustomer();
        this.idAddress = order.getIdAddress();
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
    public Float getPriceOrder() {
        return priceOrder;
    }
    public void setPriceOrder(Float priceOrder) {
        this.priceOrder = priceOrder;
    }
    public Long getIdCustomer() { return idCustomer; }
    public void setIdCustomer(Long idCustomer) { this.idCustomer = idCustomer; }
    public Long getIdAddress() {
        return idAddress;
    }
    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }
    public Long getIdOrderStatus() {
        return orderStatus.getIdOrderStatus();
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}