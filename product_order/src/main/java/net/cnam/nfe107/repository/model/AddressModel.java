package net.cnam.nfe107.repository.model;

import net.cnam.nfe107.domain.entity.Address;
import net.cnam.nfe107.domain.entity.AddressToCreate;
import net.cnam.nfe107.domain.entity.Customer;

import javax.persistence.*;

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

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "address_number")
    private String addressNumber;

    @Column(name = "street")
    private String street;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private CustomerModel customer;

    public AddressModel() {
    }

    public AddressModel(Long idAddress, String country, String city, String postalCode, String addressNumber, String street, CustomerModel customer) {
        this.idAddress = idAddress;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.addressNumber = addressNumber;
        this.street = street;
        this.customer = customer;
    }

    public AddressModel(Address address)
    {
        this.idAddress = address.getIdAddress();
        this.country = address.getCountry();
        this.city = address.getCity();
        this.postalCode = address.getPostalCode();
        this.addressNumber = address.getAddressNumber();
        this.street = address.getStreet();
        this.customer = new CustomerModel(address.getCustomer());
    }

    public AddressModel(Address address, CustomerModel customerModel)
    {
        this.idAddress = address.getIdAddress();
        this.country = address.getCountry();
        this.city = address.getCity();
        this.postalCode = address.getPostalCode();
        this.addressNumber = address.getAddressNumber();
        this.street = address.getStreet();
        this.customer = customerModel;
    }

    public AddressModel(AddressToCreate addressToCreate, CustomerModel customerModel)
    {
        this.country = addressToCreate.getCountry();
        this.city = addressToCreate.getCity();
        this.postalCode = addressToCreate.getPostalCode();
        this.addressNumber = addressToCreate.getAddressNumber();
        this.street = addressToCreate.getStreet();
        this.customer = customerModel;
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
}