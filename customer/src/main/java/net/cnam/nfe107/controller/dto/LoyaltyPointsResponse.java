package net.cnam.nfe107.controller.dto;

public class LoyaltyPointsResponse {

    private Long idCustomer;
    private Long loyaltyPoints;

    public LoyaltyPointsResponse() {
    }

    public LoyaltyPointsResponse(Long idCustomer, Long loyaltyPoints) {
        this.idCustomer = idCustomer;
        this.loyaltyPoints = loyaltyPoints;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }
    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }
    public Long getLoyaltyPoints() {
        return loyaltyPoints;
    }
    public void setLoyaltyPoints(Long loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
