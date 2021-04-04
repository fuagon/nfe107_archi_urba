package net.cnam.nfe107.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderStatus {
    private Long idOrderStatus;
    private String description;


    @JsonCreator
    public OrderStatus(@JsonProperty("idOrderStatus") Long idOrderStatus, @JsonProperty("description") String description) {
        this.idOrderStatus = idOrderStatus;
        this.description = description;
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
