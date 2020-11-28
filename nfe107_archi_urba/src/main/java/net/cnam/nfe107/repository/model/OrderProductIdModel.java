package net.cnam.nfe107.repository.model;

/*
 * @created 28/11/2020/11/2020 - 15:12
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderProductIdModel implements Serializable {
    @Column(name = "id_order")
    private Long idOrder;

    @Column(name = "id_product")
    private Long idProduct;

    public OrderProductIdModel(Long idOrder, Long idProduct) {
        this.idOrder = idOrder;
        this.idProduct = idProduct;
    }

    public OrderProductIdModel() {
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
}
