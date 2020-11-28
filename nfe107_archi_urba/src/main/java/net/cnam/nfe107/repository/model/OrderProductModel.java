package net.cnam.nfe107.repository.model;

/*
 * @created 28/11/2020/11/2020 - 14:40
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */


import javax.persistence.*;

@Entity
@Table(name = "ORDER_PRODUCT")
public class OrderProductModel{

    @EmbeddedId
    private OrderProductIdModel idOrderProduct;

    @ManyToOne()
    @MapsId("idOrder")
    @JoinColumn(name = "id_order")
    private OrderModel order;

    @ManyToOne()
    @MapsId("idProduct")
    @JoinColumn(name = "id_product")
    private ProductModel product;

    @Column(name = "quantity")
    private int quantity;



}
