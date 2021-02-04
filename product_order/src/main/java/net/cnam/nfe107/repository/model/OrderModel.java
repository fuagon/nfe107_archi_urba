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

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private CustomerModel customer;

    @ManyToOne
    @JoinColumn(name = "id_address")
    private AddressModel address;

    @ManyToOne
    @JoinColumn(name = "id_order_status")
    private OrderStatusModel orderStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, targetEntity = OrderProductModel.class)
    @Nullable
    private Set<OrderProductModel> ordersProducts = new HashSet<>();


    public OrderModel() {
    }

    public OrderModel(Long idOrder, String date, Float priceOrder, OrderStatusModel orderStatus, CustomerModel customer, AddressModel address, @Nullable Set<OrderProductModel> ordersProducts) {
        this.idOrder = idOrder;
        this.date = date;
        this.priceOrder = priceOrder;
        this.customer = customer;
        this.orderStatus = orderStatus;
        this.address = address;
        this.ordersProducts = ordersProducts;
    }

    public OrderModel(Order order)
    {
        this.idOrder = order.getIdOrder();
        this.date = order.getDate();
        this.priceOrder = order.getPriceOrder();
        this.customer = new CustomerModel(order.getCustomer());
        this.address = new AddressModel(order.getAddress());
        this.orderStatus = new OrderStatusModel(order.getOrderStatus());
    }

    public OrderModel(OrderToCreate orderToCreate)
    {
        this.date = orderToCreate.getDate();
        this.priceOrder = orderToCreate.getPriceOrder();
    }

    public OrderModel(OrderToCreate orderToCreate, CustomerModel customerModel)
    {
        this.date = orderToCreate.getDate();
        this.priceOrder = orderToCreate.getPriceOrder();
        this.customer = customerModel;
    }

    public OrderModel(Order order, CustomerModel customerModel)
    {
        this.idOrder = order.getIdOrder();
        this.date = order.getDate();
        this.priceOrder = order.getPriceOrder();
        this.customer = customerModel;
    }

    public OrderModel(OrderToCreate orderToCreate, CustomerModel customerModel, AddressModel addressModel, OrderStatusModel orderStatusModel)
    {
        this.date = orderToCreate.getDate();
        this.priceOrder = orderToCreate.getPriceOrder();
        this.customer = customerModel;
        this.address = addressModel;
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
    public CustomerModel getCustomer() { return this.customer; }
    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
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
    public AddressModel getAddress() {
        return address;
    }
    public void setAddress(AddressModel address) {
        this.address = address;
    }
}