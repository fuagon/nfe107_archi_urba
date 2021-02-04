package net.cnam.nfe107.controller.dto;

public class DeleteUserRequest {

    private Long idCustomer;

    public DeleteUserRequest() {
    }

    public DeleteUserRequest(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }
    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }
}
