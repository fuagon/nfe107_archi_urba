package net.cnam.nfe107.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CreerCommandeResponse {
    private Long idOrder;
    private Long idCustomer;
    private Long idAddress;
    private String date;
    private float priceOrder;
    private OrderStatus orderStatus;
    private List<ProductResponse> products;

    @JsonCreator
    public CreerCommandeResponse(@JsonProperty("idOrder") Long idOrder,
                                 @JsonProperty("idCustomer") Long idCustomer,
                                 @JsonProperty("idAddress") Long idAddress,
                                 @JsonProperty("date") String date,
                                 @JsonProperty("priceOrder") float priceOrder,
                                 @JsonProperty("orderStatus") OrderStatus orderStatus,
                                 @JsonProperty("products") List<ProductResponse> products
                                 ) {
        this.idOrder = idOrder;
        this.idCustomer = idCustomer;
        this.idAddress = idAddress;
        this.date = date;
        this.priceOrder = priceOrder;
        this.orderStatus = orderStatus;
        this.products = products;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(float priceOrder) {
        this.priceOrder = priceOrder;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponse> products) {
        this.products = products;
    }
}
