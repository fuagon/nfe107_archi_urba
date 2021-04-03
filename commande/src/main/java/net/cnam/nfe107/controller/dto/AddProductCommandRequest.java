package net.cnam.nfe107.controller.dto;

public class AddProductCommandRequest {
    private Long idOrder;
    private Long idProduct;
    private Long quantity;

    public AddProductCommandRequest(Long idOrder, Long idProduct, Long quantity) {
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
