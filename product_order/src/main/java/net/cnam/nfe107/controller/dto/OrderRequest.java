package net.cnam.nfe107.controller.dto;

import net.cnam.nfe107.domain.entity.Order;
import net.cnam.nfe107.domain.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderRequest {

    //Attributes

    private Long idOrder;
    private String date;
    private Float priceOrder;
    private Long idCustomer;
    private Long idAddress;
    private Long idOrderStatus;

    //Constructors

    public OrderRequest() {
    }

    public OrderRequest(Long idOrder, String date, Float priceOrder, Long idCustomer, Long idAddress, Long idOrderStatus) {
        this.idOrder = idOrder;
        this.date = date;
        this.priceOrder = priceOrder;
        this.idCustomer = idCustomer;
        this.idAddress = idAddress;
        this.idOrderStatus = idOrderStatus;
    }

    public OrderRequest(Order order) {
        this.idOrder = order.getIdOrder();
        this.date = order.getDate();
        this.priceOrder = order.getPriceOrder();
        this.idCustomer = order.getIdCustomer();
    }

    public OrderRequest(Order order, Long idCustomer) {
        this.idOrder = order.getIdOrder();
        this.date = order.getDate();
        this.priceOrder = order.getPriceOrder();
        this.idCustomer = idCustomer;
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
    public Long getIdOrderStatus() {
        return idOrderStatus;
    }
    public void setIdOrderStatus(Long idOrderStatus) {
        this.idOrderStatus = idOrderStatus;
    }
}
