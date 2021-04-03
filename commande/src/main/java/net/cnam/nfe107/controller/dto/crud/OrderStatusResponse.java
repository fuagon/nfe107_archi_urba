package net.cnam.nfe107.controller.dto.crud;

import net.cnam.nfe107.domain.entity.OrderStatus;
import net.cnam.nfe107.repository.model.OrderStatusModel;

public class OrderStatusResponse {

    //Attributes

    private Long idOrderStatus;
    private String description;

    //Constructors

    public OrderStatusResponse() {
    }

    public OrderStatusResponse(Long idOrderStatus, String description) {
        this.idOrderStatus = idOrderStatus;
        this.description = description;
    }

    public OrderStatusResponse(OrderStatus orderStatus)
    {
        this.idOrderStatus = orderStatus.getIdOrderStatus();
        this.description = orderStatus.getDescription();
    }

    public OrderStatusResponse(OrderStatusModel orderStatusModel)
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