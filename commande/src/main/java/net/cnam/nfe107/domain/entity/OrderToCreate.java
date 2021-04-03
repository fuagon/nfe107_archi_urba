package net.cnam.nfe107.domain.entity;

import net.cnam.nfe107.controller.dto.crud.AddProductToOrderRequest;
import net.cnam.nfe107.controller.dto.crud.OrderRequest;
import net.cnam.nfe107.repository.model.OrderModel;

public class OrderToCreate {

    private String date;
    private Float priceOrder;
    private Long idCustomer;
    private Long idAddress;
    private OrderStatus orderStatus;

    public OrderToCreate(String date, Long idCustomer, Long idAddress, OrderStatus orderStatus) {
        this.date = date;
        this.priceOrder = 0f;
        this.idCustomer = idCustomer;
        this.idAddress = idAddress;
        this.orderStatus = orderStatus;
    }

    public OrderToCreate(OrderModel orderModel) {
        this.date = orderModel.getDate();
        this.priceOrder = orderModel.getPriceOrder();
    }

    public OrderToCreate(OrderRequest orderRequest) {
        this.date = orderRequest.getDate();
        this.priceOrder = orderRequest.getPriceOrder();
    }

    public OrderToCreate(OrderRequest orderRequest, OrderStatus orderStatus) {
        this.date = orderRequest.getDate();
        this.priceOrder = orderRequest.getPriceOrder();
        this.idCustomer = orderRequest.getIdCustomer();
        this.idAddress = orderRequest.getIdAddress();
        this.orderStatus = orderStatus;
    }

    public OrderToCreate(AddProductToOrderRequest addProductToOrderRequest, OrderStatus orderStatus)
    {
        this.date = addProductToOrderRequest.getDate();
        this.priceOrder = addProductToOrderRequest.getPriceOrder();
        this.idCustomer = addProductToOrderRequest.getIdCustomer();
        this.idAddress = addProductToOrderRequest.getIdAddress();
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
    public Long getIdAddress() {
        return idAddress;
    }
    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }
    public Long getIdCustomer() {
        return idCustomer;
    }
    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
