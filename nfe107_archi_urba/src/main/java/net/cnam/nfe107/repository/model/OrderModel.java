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
    private Long id;

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
}
