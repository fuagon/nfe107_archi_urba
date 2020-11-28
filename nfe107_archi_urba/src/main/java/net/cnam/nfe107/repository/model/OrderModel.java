package net.cnam.nfe107.repository.model;

/*
 * @created 29/10/2020/10/2020 - 10:23
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="table_order")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long idOrder;

    @Column(name = "date")
    private String date;

    @Column(name = "totalPrice")
    private float totalPrice;

    @ManyToOne
    @JoinColumn(name = "id_order_status")
    private OrderStatusModel orderStatus;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private CustomerModel customer;

    @ManyToOne
    @JoinColumn(name = "id_address")
    private AddressModel address;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, targetEntity = OrderProductModel.class)
    @Nullable
    private Set<OrderProductModel> ordersProducts = new HashSet<>();

    public OrderModel() {
    }

    public OrderModel(Long idOrder, String date, float totalPrice, OrderStatusModel orderStatus, CustomerModel customer, AddressModel address, @Nullable Set<OrderProductModel> ordersProducts) {
        this.idOrder = idOrder;
        this.date = date;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.customer = customer;
        this.address = address;
        this.ordersProducts = ordersProducts;
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

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatusModel getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusModel orderStatus) {
        this.orderStatus = orderStatus;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    @Nullable
    public Set<OrderProductModel> getOrdersProducts() {
        return ordersProducts;
    }

    public void setOrdersProducts(@Nullable Set<OrderProductModel> ordersProducts) {
        this.ordersProducts = ordersProducts;
    }
}
