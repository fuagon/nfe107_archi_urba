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
    private OrderProductIdModel id;

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

    public OrderProductModel() {
    }

    public OrderProductModel(OrderModel order, ProductModel product, int quantity) {
        this.id = new OrderProductIdModel(order.getIdOrder(), product.getId());
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public OrderProductIdModel getId() {
        return id;
    }

    public void setId(OrderProductIdModel id) {
        this.id = id;
    }

    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
