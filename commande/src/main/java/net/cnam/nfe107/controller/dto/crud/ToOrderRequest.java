package net.cnam.nfe107.controller.dto.crud;

public class ToOrderRequest {

    private Long idOrder;
    private Long loyaltyPoints;

    public ToOrderRequest() {
    }

    public ToOrderRequest(Long idOrder, Long loyaltyPoints) {
        this.idOrder = idOrder;
        this.loyaltyPoints = loyaltyPoints;
    }

    public Long getIdOrder() {
        return idOrder;
    }
    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }
    public Long getLoyaltyPoints() {
        return loyaltyPoints;
    }
    public void setLoyaltyPoints(Long loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}