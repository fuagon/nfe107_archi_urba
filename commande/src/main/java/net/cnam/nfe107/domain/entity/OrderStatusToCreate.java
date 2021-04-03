package net.cnam.nfe107.domain.entity;

import net.cnam.nfe107.controller.dto.crud.OrderStatusRequest;

public class OrderStatusToCreate {

    private String description;

    public OrderStatusToCreate() {
    }

    public OrderStatusToCreate(String description) {
        this.description = description;
    }

    public OrderStatusToCreate(OrderStatusRequest orderStatusRequest) {
        this.description = orderStatusRequest.getDescription();
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
