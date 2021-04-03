package net.cnam.nfe107.controller.dto.crud;

import net.cnam.nfe107.domain.entity.Order;

public class OrderStatusRequest {

    //Attributes

    private Long idOrderStatus;
    private String description;

    //Constructors

    public OrderStatusRequest() {
    }

    public OrderStatusRequest(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getIdOrderStatus() {
        return idOrderStatus;
    }
    public void setIdOrderStatus(Long idOrderStatus) {
        this.idOrderStatus = idOrderStatus;
    }
}
