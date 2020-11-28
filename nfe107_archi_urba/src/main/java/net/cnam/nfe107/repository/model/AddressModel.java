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
@Table(name="table_address")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Long idAddress;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "addressNumber")
    private String addressNumber;

    @Column(name = "street")
    private String street;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private CustomerModel customer;

    @OneToMany(mappedBy = "address", targetEntity = OrderModel.class)
    @Nullable
    private Set<OrderModel> orders = new HashSet<>();

    public AddressModel() {
    }

    public AddressModel(Long idAddress, String country, String city, String postalCode, String addressNumber, String street, CustomerModel customer, @Nullable Set<OrderModel> orders) {
        this.idAddress = idAddress;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.addressNumber = addressNumber;
        this.street = street;
        this.customer = customer;
        this.orders = orders;
    }

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    @Nullable
    public Set<OrderModel> getOrders() {
        return orders;
    }

    public void setOrders(@Nullable Set<OrderModel> orders) {
        this.orders = orders;
    }
}
