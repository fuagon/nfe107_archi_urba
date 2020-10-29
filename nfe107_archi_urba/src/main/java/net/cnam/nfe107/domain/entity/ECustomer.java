package net.cnam.nfe107.domain.entity;

/*
 * @created 29/10/2020/10/2020 - 17:48
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import net.cnam.nfe107.controller.dto.CustomerDTOInWithId;
import net.cnam.nfe107.controller.dto.CustomerDTOOut;
import net.cnam.nfe107.repository.model.Address;
import net.cnam.nfe107.repository.model.Customer;

public class ECustomer {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private Address address;

    public ECustomer(Long id, String firstname, String lastname, String email, String phoneNumber, Address address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public ECustomer(Customer customer) {
        this.id = customer.getId();
        this.firstname = customer.getFirstname();
        this.lastname = customer.getLastname();
        this.email = customer.getEmail();
        this.phoneNumber = customer.getPhoneNumber();
        this.address = customer.getAddress();
    }

    public ECustomer(CustomerDTOOut customerDTOOut) {
        this.id = customerDTOOut.getId();
        this.firstname = customerDTOOut.getFirstname();
        this.lastname = customerDTOOut.getLastname();
        this.email = customerDTOOut.getEmail();
        this.phoneNumber = customerDTOOut.getPhoneNumber();
        this.address = new Address(customerDTOOut.getAddress());
    }
    public ECustomer(CustomerDTOInWithId customerDTOOut, Address address) {
        this.id = customerDTOOut.getId();
        this.firstname = customerDTOOut.getFirstname();
        this.lastname = customerDTOOut.getLastname();
        this.email = customerDTOOut.getEmail();
        this.phoneNumber = customerDTOOut.getPhoneNumber();
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
