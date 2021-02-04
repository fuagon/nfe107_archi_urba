package net.cnam.nfe107.domain.entity;

import net.cnam.nfe107.controller.dto.AddressRequest;
import net.cnam.nfe107.repository.model.AddressModel;

import java.util.ArrayList;
import java.util.List;

public class Address {

    private Long idAddress;
    private String country;
    private String city;
    private String postalCode;
    private String addressNumber;
    private String street;
    private Long idCustomer;

    public Address(Long idAddress, String country, String city, String postalCode, String addressNumber, String street, Long idCustomer) {
        this.idAddress = idAddress;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.addressNumber = addressNumber;
        this.street = street;
        this.idCustomer = idCustomer;
    }

    public Address(AddressModel addressModel) {
        this.idAddress = addressModel.getIdAddress();
        this.country = addressModel.getCountry();
        this.city = addressModel.getCity();
        this.postalCode = addressModel.getPostalCode();
        this.addressNumber = addressModel.getAddressNumber();
        this.street = addressModel.getStreet();
        this.idCustomer = addressModel.getIdCustomer();
    }

    public Address(AddressRequest addressRequest) {
        this.idAddress = addressRequest.getIdAddress();
        this.country = addressRequest.getCountry();
        this.city = addressRequest.getCity();
        this.postalCode = addressRequest.getPostalCode();
        this.addressNumber = addressRequest.getAddressNumber();
        this.street = addressRequest.getStreet();
        this.idCustomer = addressRequest.getIdCustomer();
    }

    public Address(AddressRequest addressRequest, Long idCustomer) {
        this.idAddress = addressRequest.getIdAddress();
        this.country = addressRequest.getCountry();
        this.city = addressRequest.getCity();
        this.postalCode = addressRequest.getPostalCode();
        this.addressNumber = addressRequest.getAddressNumber();
        this.street = addressRequest.getStreet();
        this.idCustomer = idCustomer;
    }

    public Address(Address address, Long idCustomer) {
        this.idAddress = address.getIdAddress();
        this.country = address.getCountry();
        this.city = address.getCity();
        this.postalCode = address.getPostalCode();
        this.addressNumber = address.getAddressNumber();
        this.street = address.getStreet();
        this.idCustomer = idCustomer;
    }

    public List<Address> address(List<AddressModel> all) {
        List<Address> addresses = new ArrayList<>();

        for (AddressModel addressModel:all) {
            addresses.add(new Address(addressModel));
        }
        return addresses;
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
    public Long getIdCustomer() {
        return idCustomer;
    }
    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }
}
