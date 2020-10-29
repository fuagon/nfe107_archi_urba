package net.cnam.nfe107.repository.model;

/*
 * @created 29/10/2020/10/2020 - 10:23
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="table_order")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_order")
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "totalPrice")
    private float totalPrice;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    @Nullable
    private Set<Product> products = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "customers_orders",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_customer")
    )
    @Nullable
    private Set<Customer> customers = new HashSet<>();

    public Order() {
    }

    public Order(Long id, String date, float totalPrice, @Nullable Set<Product> products, @Nullable Set<Customer> customers) {
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
        this.products = products;
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Nullable
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(@Nullable Set<Product> products) {
        this.products = products;
    }

    @Nullable
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(@Nullable Set<Customer> customers) {
        this.customers = customers;
    }


}
