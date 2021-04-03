package net.cnam.nfe107.repository.model;

import com.sun.istack.Nullable;
import net.cnam.nfe107.domain.entity.Order;
import net.cnam.nfe107.domain.entity.OrderToCreate;

import javax.persistence.*;
import java.util.HashSet;
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

    @Column(name = "price_order")
    private Float priceOrder;

    @JoinColumn(name = "id_customer")
    private Long idCustomer;

    @JoinColumn(name = "id_address")
    private Long idAddress;

    @ManyToOne
    @JoinColumn(name = "id_order_status")
    private OrderStatusModel orderStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, targetEntity = OrderProductModel.class)
    @Nullable
    private Set<OrderProductModel> ordersProducts = new HashSet<>();


    public OrderModel() {
    }

    public OrderModel(Long idOrder, String date, Float priceOrder, OrderStatusModel orderStatus, Long idCustomer, Long idAddress, @Nullable Set<OrderProductModel> ordersProducts) {
        this.idOrder = idOrder;
        this.date = date;
        this.priceOrder = priceOrder;
        this.idCustomer = idCustomer;
        this.orderStatus = orderStatus;
        this.idAddress = idAddress;
        this.ordersProducts = ordersProducts;
    }

    public OrderModel(Order order)
    {
        this.idOrder = order.getIdOrder();
        this.date = order.getDate();
        this.priceOrder = order.getPriceOrder();
        this.idCustomer = order.getIdCustomer();
        this.idAddress = order.getIdAddress();
        this.orderStatus = new OrderStatusModel(order.getOrderStatus());
    }


    public OrderModel(OrderToCreate orderToCreate)
    {
        this.date = orderToCreate.getDate();
        this.priceOrder = orderToCreate.getPriceOrder();
        this.idCustomer = orderToCreate.getIdCustomer();
    }



    public OrderModel(OrderToCreate orderToCreate, OrderStatusModel orderStatusModel)
    {
        this.date = orderToCreate.getDate();
        this.priceOrder = orderToCreate.getPriceOrder();
        this.idCustomer = orderToCreate.getIdCustomer();
        this.idAddress = orderToCreate.getIdAddress();
        this.orderStatus = orderStatusModel;
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
    public Long getIdCustomer() { return this.idCustomer; }
    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }
    @Nullable
    public Set<OrderProductModel> getOrdersProducts() {
        return ordersProducts;
    }
    public void setOrdersProducts(@Nullable Set<OrderProductModel> ordersProducts) {
        this.ordersProducts = ordersProducts;
    }
    public OrderStatusModel getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(OrderStatusModel orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Long getIdAddress() {
        return idAddress;
    }
    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }
}