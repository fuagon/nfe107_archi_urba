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
    private Long idOrderStatus;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "orderStatus", targetEntity = OrderModel.class)
    private Set<OrderModel> orders = new HashSet<>();

    public OrderStatusModel() {
    }

    public OrderStatusModel(Long idOrderStatus, String description, Set<OrderModel> orders) {
        this.idOrderStatus = idOrderStatus;
        this.description = description;
        this.orders = orders;
    }

    public Long getIdOrderStatus() {
        return idOrderStatus;
    }

    public void setIdOrderStatus(Long idOrderStatus) {
        this.idOrderStatus = idOrderStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<OrderModel> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderModel> orders) {
        this.orders = orders;
    }
}
