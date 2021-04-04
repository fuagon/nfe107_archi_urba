package net.cnam.nfe107.domain.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ResultatCreationCommande {
    public Long idOrder;
    public String date;
    public Long idCustomer;
    public Long idAddress;
    public Long idProduct;
    public Long quantity;

    @JsonCreator
    public ResultatCreationCommande(Long idOrder, String date, Long idCustomer, Long idAddress, Long idProduct, Long quantity) {
        this.idOrder = idOrder;
        this.date = date;
        this.idCustomer = idCustomer;
        this.idAddress = idAddress;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }
}
