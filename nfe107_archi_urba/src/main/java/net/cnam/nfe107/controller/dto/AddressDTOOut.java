package net.cnam.nfe107.controller.dto;

/*
 * @created 29/10/2020/10/2020 - 15:32
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import net.cnam.nfe107.domain.entity.EAddress;

public class AddressDTOOut {
    private Long id;
    private String country;
    private String city;
    private String postalCode;
    private String addressNumber;
    private String street;

    public AddressDTOOut(Long id, String country, String city, String postalCode, String addressNumber, String street) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.addressNumber = addressNumber;
        this.street = street;
    }

    public AddressDTOOut(EAddress eAddress){
        this.id = eAddress.getId();
        this.country = eAddress.getCountry();
        this.city = eAddress.getCity();
        this.postalCode = eAddress.getPostalCode();
        this.addressNumber = eAddress.getAddressNumber();
        this.street = eAddress.getStreet();
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

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
