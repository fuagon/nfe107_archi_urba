package net.cnam.nfe107.domain.entity;


import net.cnam.nfe107.controller.dto.crud.OrderStatusRequest;
import net.cnam.nfe107.repository.model.OrderStatusModel;

public class OrderStatus {

    private Long idOrderStatus;
    private String description;

    public OrderStatus() {
    }

    public OrderStatus(Long idOrderStatus, String description) {
        this.idOrderStatus = idOrderStatus;
        this.description = description;
    }

    public OrderStatus(OrderStatusRequest orderStatusRequest)
    {
        this.idOrderStatus = orderStatusRequest.getIdOrderStatus();
        this.description = orderStatusRequest.getDescription();
    }

    public OrderStatus(OrderStatusModel orderStatusModel)
    {
        this.idOrderStatus = orderStatusModel.getIdOrderStatus();
        this.description = orderStatusModel.getDescription();
    }

    public Long getIdOrderStatus() {
        return idOrderStatus;
    }
    public void setIdOrderStatus(Long idOrderStatus) {
        this.idOrderStatus = idOrderStatus;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
