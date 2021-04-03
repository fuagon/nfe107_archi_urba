package net.cnam.nfe107.controller.dto.crud;

public class AddProductToOrderRequest {

    private Long idOrder;
    private String date;
    private Float priceOrder;
    private Long idCustomer;
    private Long idAddress;
    private Long idOrderStatus;
    private Long idProduct;
    private Long quantity;

    public AddProductToOrderRequest() {
    }

    public AddProductToOrderRequest(Long idOrder, String date, Float priceOrder, Long idCustomer, Long idAddress, Long idOrderStatus, Long idProduct, Long quantity) {
        this.idOrder = idOrder;
        this.date = date;
        this.priceOrder = priceOrder;
        this.idCustomer = idCustomer;
        this.idAddress = idAddress;
        this.idOrderStatus = idOrderStatus;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public Long getIdOrder() {
        return idOrder;
    }
    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Float getPriceOrder() {
        return priceOrder;
    }
    public void setPriceOrder(Float priceOrder) {
        this.priceOrder = priceOrder;
    }
    public Long getIdCustomer() {
        return idCustomer;
    }
    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }
    public Long getIdAddress() {
        return idAddress;
    }
    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }
    public Long getIdOrderStatus() {
        return idOrderStatus;
    }
    public void setIdOrderStatus(Long idOrderStatus) {
        this.idOrderStatus = idOrderStatus;
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
