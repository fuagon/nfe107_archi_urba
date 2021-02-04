package net.cnam.nfe107.controller.dto;

import net.cnam.nfe107.domain.entity.Address;
import net.cnam.nfe107.domain.entity.Customer;
import net.cnam.nfe107.repository.model.AddressModel;

public class AddressResponse {

    //Attributes

    private Long idAddress;
    private String country;
    private String city;
    private String postalCode;
    private String addressNumber;
    private String street;
    private Customer customer;

    //Constructors

    public AddressResponse(Long idAddress, String country, String city, String postalCode, String addressNumber, String street) {
        this.idAddress = idAddress;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.addressNumber = addressNumber;
        this.street = street;
    }

    public AddressResponse(Address address) {
        this.idAddress = address.getIdAddress();
        this.country = address.getCountry();
        this.city = address.getCity();
        this.postalCode = address.getPostalCode();
        this.addressNumber = address.getAddressNumber();
        this.street = address.getStreet();
        this.customer = address.getCustomer();
    }

    public AddressResponse(AddressModel addressModel) {
        this.idAddress = addressModel.getIdAddress();
        this.country = addressModel.getCountry();
        this.city = addressModel.getCity();
        this.postalCode = addressModel.getPostalCode();
        this.addressNumber = addressModel.getAddressNumber();
        this.street = addressModel.getStreet();
    }

    public AddressResponse(Address address, Customer customer) {
        this.idAddress = address.getIdAddress();
        this.country = address.getCountry();
        this.city = address.getCity();
        this.postalCode = address.getPostalCode();
        this.addressNumber = address.getAddressNumber();
        this.street = address.getStreet();
        this.customer = customer;
    }

    //Getters and Setters

    public Long getIdAddress() { return idAddress; }
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
    public Long getIdCustomer () { return customer.getIdCustomer(); }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}