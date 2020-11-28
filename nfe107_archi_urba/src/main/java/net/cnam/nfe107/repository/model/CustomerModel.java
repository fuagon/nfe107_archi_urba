package net.cnam.nfe107.repository.model;

/*
 * @created 29/10/2020/10/2020 - 10:22
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
@Table(name="table_customer")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long idCustomer;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "loyaltyPoints", nullable = false)
    private int loyaltyPoints;

    @OneToMany(mappedBy = "customer", targetEntity = AddressModel.class)
    private Set<AddressModel> addresses = new HashSet<>();

    @OneToMany (mappedBy = "customer", targetEntity = OrderModel.class)
    private Set<OrderModel> orders = new HashSet<>();

    public CustomerModel() {
    }

    public CustomerModel(Long idCustomer, String firstname, String lastname, String email, String phoneNumber, int loyaltyPoints, Set<AddressModel> addresses, Set<OrderModel> orders) {
        this.idCustomer = idCustomer;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.loyaltyPoints = loyaltyPoints;
        this.addresses = addresses;
        this.orders = orders;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
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

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public Set<AddressModel> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressModel> addresses) {
        this.addresses = addresses;
    }

    public Set<OrderModel> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderModel> orders) {
        this.orders = orders;
    }
}
