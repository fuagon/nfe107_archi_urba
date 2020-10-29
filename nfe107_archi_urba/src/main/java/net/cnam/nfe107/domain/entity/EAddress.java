package net.cnam.nfe107.domain.entity;

/*
 * @created 29/10/2020/10/2020 - 15:34
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import net.cnam.nfe107.controller.dto.AddressDTOIn;
import net.cnam.nfe107.controller.dto.AddressDTOInWithId;
import net.cnam.nfe107.controller.dto.AddressDTOOut;
import net.cnam.nfe107.repository.model.Address;

public class EAddress {
    private Long id;
    private String country;
    private String city;
    private String postalCode;
    private String addressNumber;
    private String street;

    public EAddress(Long id, String country, String city, String postalCode, String addressNumber, String street) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.addressNumber = addressNumber;
        this.street = street;
    }

    public EAddress(Address address){
        this.id = address.getId();
        this.country = address.getCountry();
        this.city = address.getCity();
        this.postalCode = address.getPostalCode();
        this.addressNumber = address.getAddressNumber();
        this.street = address.getStreet();
    }

    public EAddress(AddressDTOIn addressDTOIn){
        this.country = addressDTOIn.getCountry();
        this.city = addressDTOIn.getCity();
        this.postalCode = addressDTOIn.getPostalCode();
        this.addressNumber = addressDTOIn.getAddressNumber();
        this.street = addressDTOIn.getStreet();
    }
    public EAddress(AddressDTOInWithId addressDTOIn){
        this.id = addressDTOIn.getId();
        this.country = addressDTOIn.getCountry();
        this.city = addressDTOIn.getCity();
        this.postalCode = addressDTOIn.getPostalCode();
        this.addressNumber = addressDTOIn.getAddressNumber();
        this.street = addressDTOIn.getStreet();
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
