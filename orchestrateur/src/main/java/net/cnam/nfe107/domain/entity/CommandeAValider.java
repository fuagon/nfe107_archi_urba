package net.cnam.nfe107.domain.entity;

public class CommandeAValider {
    private Long idOrder;
    private Long fidelityPointUsed;
    private String cardNumber;
    private String cardName;
    private String cvc2;

    public CommandeAValider(Long idOrder, Long fidelityPointUsed, String cardNumber, String cardName, String cvc2) {
        this.idOrder = idOrder;
        this.fidelityPointUsed = fidelityPointUsed;
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cvc2 = cvc2;
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
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getCardName() {
        return cardName;
    }
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    public String getCvc2() {
        return cvc2;
    }
    public void setCvc2(String cvc2) {
        this.cvc2 = cvc2;
    }
}
