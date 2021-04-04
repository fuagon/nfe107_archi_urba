package net.cnam.nfe107.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ValidateCommandeResponse {

    private Long idOrder;
    private Long idCustomer;
    private Long idAddress;
    private String date;
    private OrderStatus orderStatus;
    private Long fidelityPointUsed;
    private float priceOrder;
    private float reduction;
    private float finalPrice;
    private List<ProductResponse> products;

    @JsonCreator
    public ValidateCommandeResponse(@JsonProperty("idOrder") Long idOrder,
                                    @JsonProperty("idCustomer") Long idCustomer,
                                    @JsonProperty("idAddress") Long idAddress,
                                    @JsonProperty("date") String date,
                                    @JsonProperty("orderStatus")OrderStatus orderStatus,
                                    @JsonProperty("fidelityPointUsed") Long fidelityPointUsed,
                                    @JsonProperty("priceOrder") float priceOrder,
                                    @JsonProperty("reduction") float reduction,
                                    @JsonProperty("finalPrice") float finalPrice,
                                    @JsonProperty("products") List<ProductResponse> products) {
        this.idOrder = idOrder;
        this.idCustomer = idCustomer;
        this.idAddress = idAddress;
        this.date = date;
        this.orderStatus = orderStatus;
        this.fidelityPointUsed = fidelityPointUsed;
        this.priceOrder = priceOrder;
        this.reduction = reduction;
        this.finalPrice = finalPrice;
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getFidelityPointUsed() {
        return fidelityPointUsed;
    }

    public void setFidelityPointUsed(Long fidelityPointUsed) {
        this.fidelityPointUsed = fidelityPointUsed;
    }

    public float getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(float priceOrder) {
        this.priceOrder = priceOrder;
    }

    public float getReduction() {
        return reduction;
    }

    public void setReduction(float reduction) {
        this.reduction = reduction;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponse> products) {
        this.products = products;
    }
}
