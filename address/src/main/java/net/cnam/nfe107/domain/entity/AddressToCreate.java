package net.cnam.nfe107.domain.entity;

import net.cnam.nfe107.controller.dto.AddressRequest;
import net.cnam.nfe107.repository.model.AddressModel;

public class AddressToCreate {

    private String country;
    private String city;
    private String postalCode;
    private String addressNumber;
    private String street;
    private Long idCustomer;

    public AddressToCreate(String country, String city, String postalCode, String addressNumber, String street, Long idCustomer) {
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.addressNumber = addressNumber;
        this.street = street;
        this.idCustomer = idCustomer;
    }

    public AddressToCreate(AddressModel addressModel) {
        this.country = addressModel.getCountry();
        this.city = addressModel.getCity();
        this.postalCode = addressModel.getPostalCode();
        this.addressNumber = addressModel.getAddressNumber();
        this.street = addressModel.getStreet();
    }

    public AddressToCreate(AddressRequest addressRequest) {
        this.country = addressRequest.getCountry();
        this.city = addressRequest.getCity();
        this.postalCode = addressRequest.getPostalCode();
        this.addressNumber = addressRequest.getAddressNumber();
        this.street = addressRequest.getStreet();
        this.idCustomer = addressRequest.getIdCustomer();
    }

    /*public AddressToCreate(SignUpRequest signUpRequest) {
        this.country = signUpRequest.getCountry();
        this.city = signUpRequest.getCity();
        this.postalCode = signUpRequest.getPostalCode();
        this.addressNumber = signUpRequest.getAddressNumber();
        this.street = signUpRequest.getStreet();
    }*/

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
    public Long getIdCustomer() {
        return idCustomer;
    }
    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }
}
