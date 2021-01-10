package net.cnam.nfe107.domain.entity;

import net.cnam.nfe107.controller.dto.CustomerRequest;
import net.cnam.nfe107.controller.dto.SignUpRequest;
import net.cnam.nfe107.repository.model.CustomerModel;

public class CustomerToCreate {

    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private Long loyaltyPoints;

    public CustomerToCreate(String firstname, String lastname, String email, String phoneNumber, Long loyaltyPoints) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.loyaltyPoints = loyaltyPoints;
    }

    public CustomerToCreate(CustomerModel customerModel) {
        this.firstname = customerModel.getFirstname();
        this.lastname = customerModel.getLastname();
        this.email = customerModel.getEmail();
        this.phoneNumber = customerModel.getPhoneNumber();
        this.loyaltyPoints = customerModel.getLoyaltyPoints();
    }

    public CustomerToCreate(CustomerRequest customerRequest) {
        this.firstname = customerRequest.getFirstname();
        this.lastname = customerRequest.getLastname();
        this.email = customerRequest.getEmail();
        this.phoneNumber = customerRequest.getPhoneNumber();
        this.loyaltyPoints = customerRequest.getLoyaltyPoints();
    }

    public CustomerToCreate(SignUpRequest signUpRequest)
    {
        this.firstname = signUpRequest.getFirstname();
        this.lastname = signUpRequest.getLastname();
        this.email = signUpRequest.getEmail();
        this.phoneNumber = signUpRequest.getPhoneNumber();
        this.loyaltyPoints = Long.valueOf(0);
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
