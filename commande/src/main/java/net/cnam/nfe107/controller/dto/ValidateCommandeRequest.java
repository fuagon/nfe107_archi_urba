package net.cnam.nfe107.controller.dto;

public class ValidateCommandeRequest {
    private Long idOrder;
    private Long fidelityPointUsed;

    public ValidateCommandeRequest(Long idOrder, Long fidelityPointUsed) {
        this.idOrder = idOrder;
        this.fidelityPointUsed = fidelityPointUsed;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Long getFidelityPointUsed() {
        return fidelityPointUsed;
    }

    public void setFidelityPointUsed(Long fidelityPointUsed) {
        this.fidelityPointUsed = fidelityPointUsed;
    }
}
