package net.cnam.nfe107.controller.dto;

import net.cnam.nfe107.domain.entity.Address;
import net.cnam.nfe107.domain.entity.Customer;
import net.cnam.nfe107.domain.entity.Order;
import net.cnam.nfe107.repository.model.CustomerModel;

import java.util.List;

public class CustomerResponse {

    //Attributes

    private Long idCustomer;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private Long loyaltyPoints;

    //Constructors

    public CustomerResponse(Long idCustomer, String firstname, String lastname, String email, String phoneNumber, Long loyaltyPoints) {
        this.idCustomer = idCustomer;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.loyaltyPoints = loyaltyPoints;
    }

    public CustomerResponse(Customer customer)
    {
        this.idCustomer = customer.getIdCustomer();
        this.firstname = customer.getFirstname();
        this.lastname = customer.getLastname();
        this.email = customer.getEmail();
        this.phoneNumber = customer.getPhoneNumber();
        this.loyaltyPoints = customer.getLoyaltyPoints();
    }

    public CustomerResponse(CustomerModel customerModel) {
        this.idCustomer = customerModel.getIdCustomer();
        this.firstname = customerModel.getFirstname();
        this.lastname = customerModel.getLastname();
        this.email = customerModel.getEmail();
        this.phoneNumber = customerModel.getPhoneNumber();
        this.loyaltyPoints = customerModel.getLoyaltyPoints();
    }

    //Getters and setters

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