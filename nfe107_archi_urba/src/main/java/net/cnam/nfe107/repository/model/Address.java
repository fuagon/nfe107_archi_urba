package net.cnam.nfe107.repository.model;

/*
 * @created 29/10/2020/10/2020 - 10:22
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import net.cnam.nfe107.domain.entity.EAddress;
import net.cnam.nfe107.domain.entity.EAddressToCreate;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="table_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Long id;

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

    @Column(name = "customers")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,
            targetEntity = Customer.class)
    @Nullable
    private Set<Customer> customers = new HashSet<>();

    public Address() {
    }

    public Address(String country, String city, String postalCode, String addressNumber, String street) {
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.addressNumber = addressNumber;
        this.street = street;
    }
    public Address(Long id, String country, String city, String postalCode, String addressNumber, String street) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.addressNumber = addressNumber;
        this.street = street;
    }

    public Address(EAddress eAddress) {
        this.id = eAddress.getId();
        this.country = eAddress.getCountry();
        this.city = eAddress.getCity();
        this.postalCode = eAddress.getPostalCode();
        this.addressNumber = eAddress.getAddressNumber();
        this.street = eAddress.getStreet();
    }

    public Address(EAddressToCreate eAddressToCreate) {
        this.country = eAddressToCreate.getCountry();
        this.city = eAddressToCreate.getCity();
        this.postalCode = eAddressToCreate.getPostalCode();
        this.addressNumber = eAddressToCreate.getAddressNumber();
        this.street = eAddressToCreate.getStreet();
    }

    public Address(Long id, String country, String city, String postalCode, String addressNumber, String street, Set<Customer> customers) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.addressNumber = addressNumber;
        this.street = street;
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setAddressNumber(String adressNumber) {
        this.addressNumber = adressNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Nullable
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(@Nullable Set<Customer> customers) {
        this.customers = customers;
    }
}
