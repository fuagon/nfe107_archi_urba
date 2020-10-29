package net.cnam.nfe107.repository.model;

/*
 * @created 29/10/2020/10/2020 - 10:22
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import net.cnam.nfe107.domain.entity.ECustomer;
import net.cnam.nfe107.domain.entity.ECustomerToCreate;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="table_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @ManyToOne @JoinColumn(name="address", nullable=false )
    @Nullable
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "customers_orders",
            joinColumns = @JoinColumn(name = "id_customer"),
            inverseJoinColumns = @JoinColumn(name = "id_order")
    )
    @Nullable
    private Set<Order> orders = new HashSet<>();

    public Customer() {
    }

    public Customer(Long id, String firstname, String lastname, String email, String phoneNumber, Address address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Customer(ECustomerToCreate eCustomerToCreate) {
        this.firstname = eCustomerToCreate.getFirstname();
        this.lastname = eCustomerToCreate.getLastname();
        this.email = eCustomerToCreate.getEmail();
        this.phoneNumber = eCustomerToCreate.getPhoneNumber();
        this.address = eCustomerToCreate.getAddress();
    }

    public Customer(ECustomer eCustomer) {
        this.id = eCustomer.getId();
        this.firstname = eCustomer.getFirstname();
        this.lastname = eCustomer.getLastname();
        this.email = eCustomer.getEmail();
        this.address = eCustomer.getAddress();
        this.phoneNumber = eCustomer.getPhoneNumber();
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nullable
    public Address getAddress() {
        return address;
    }

    public void setAddress(@Nullable Address address) {
        this.address = address;
    }

    @Nullable
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(@Nullable Set<Order> orders) {
        this.orders = orders;
    }
}
