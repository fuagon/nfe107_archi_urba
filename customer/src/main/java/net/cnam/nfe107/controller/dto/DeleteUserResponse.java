package net.cnam.nfe107.controller.dto;

public class DeleteUserResponse {

    private Long idCustomer;

    public DeleteUserResponse() {
    }

    public DeleteUserResponse(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }
    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }
}
