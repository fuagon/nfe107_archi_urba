package net.cnam.nfe107.repository.model;

/*
 * @created 27/11/2020/11/2020 - 17:52
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="table_order_status")
public class OrderStatusModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_status")
    private Long id;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "orderStatus", targetEntity = OrderModel.class)
    private Set<OrderModel> orders = new HashSet<>();

    public OrderStatusModel() {
    }
}
