package net.cnam.nfe107.domain.entity;

public class CommandeACreer {
    private String date;
    private Long idCustomer;
    private Long idAddress;
    private Long idProduct;
    private Long quantity;

    public CommandeACreer(String date, Long idCustomer, Long idAddress, Long idProduct, Long quantity) {
        this.date = date;
        this.idCustomer = idCustomer;
        this.idAddress = idAddress;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
