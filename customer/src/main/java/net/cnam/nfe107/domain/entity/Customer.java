package net.cnam.nfe107.domain.entity;

import com.sun.istack.Nullable;
import net.cnam.nfe107.controller.dto.CustomerRequest;
import net.cnam.nfe107.repository.model.CustomerModel;

import java.util.List;

public class Customer {

    private Long idCustomer;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private Long loyaltyPoints;

    public Customer() {
    }

    public Customer(Long idCustomer, String firstname, String lastname, String email, String phoneNumber, Long loyaltyPoints) {
        this.idCustomer = idCustomer;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.loyaltyPoints = loyaltyPoints;
    }

    public Customer(CustomerModel customerModel) {
        this.idCustomer = customerModel.getIdCustomer();
        this.firstname = customerModel.getFirstname();
        this.lastname = customerModel.getLastname();
        this.email = customerModel.getEmail();
        this.phoneNumber = customerModel.getPhoneNumber();
        this.loyaltyPoints = customerModel.getLoyaltyPoints();
    }

    public Customer(CustomerRequest customerRequest) {
        this.idCustomer = customerRequest.getIdCustomer();
        this.firstname = customerRequest.getFirstname();
        this.lastname = customerRequest.getLastname();
        this.email = customerRequest.getEmail();
        this.phoneNumber = customerRequest.getPhoneNumber();
        this.loyaltyPoints = customerRequest.getLoyaltyPoints();
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
    public Long getLoyaltyPoints() {
        return loyaltyPoints;
    }
    public void setLoyaltyPoints(Long loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
