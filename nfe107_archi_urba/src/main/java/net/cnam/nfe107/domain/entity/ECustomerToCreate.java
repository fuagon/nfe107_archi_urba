package net.cnam.nfe107.domain.entity;

/*
 * @created 29/10/2020/10/2020 - 17:48
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import net.cnam.nfe107.controller.dto.AddressDTOIn;
import net.cnam.nfe107.controller.dto.CustomerDTOIn;
import net.cnam.nfe107.controller.dto.CustomerDTOInWithId;
import net.cnam.nfe107.controller.dto.CustomerDTOOut;
import net.cnam.nfe107.repository.model.Address;

public class ECustomerToCreate {

    private String firstname;
    private String lastname;
    private String email;
    private Address address;
    private String phoneNumber;

    public ECustomerToCreate(String firstname, String lastname, String email, Address address, String phoneNumber){
        this.firstname=firstname;
        this.lastname=lastname;
        this.email=email;
        this.address= address;
        this.phoneNumber=phoneNumber;
    }

    public ECustomerToCreate(CustomerDTOInWithId customerDTOIn, Address address){
        this.firstname = customerDTOIn.getFirstname();
        this.lastname = customerDTOIn.getLastname();
        this.email = customerDTOIn.getEmail();
        this.address = address;
        this.phoneNumber=customerDTOIn.getPhoneNumber();
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
