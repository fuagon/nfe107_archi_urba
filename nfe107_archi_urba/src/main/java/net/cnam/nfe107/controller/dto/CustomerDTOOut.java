package net.cnam.nfe107.controller.dto;

/*
 * @created 29/10/2020/10/2020 - 17:54
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import net.cnam.nfe107.domain.entity.ECustomer;
import net.cnam.nfe107.repository.AddressRepository;
import net.cnam.nfe107.repository.model.Address;

public class CustomerDTOOut {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private AddressDTOOut address;

    public CustomerDTOOut(Long id, String firstname, String lastname, String email, String phoneNumber, AddressDTOOut address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public CustomerDTOOut(ECustomer eCustomer) {
        this.id = eCustomer.getId();
        this.firstname = eCustomer.getFirstname();
        this.lastname = eCustomer.getLastname();
        this.email = eCustomer.getEmail();
        this.phoneNumber = eCustomer.getPhoneNumber();
        this.address = new AddressDTOOut(eCustomer.getAddress());
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

    public AddressDTOOut getAddress() {
        return address;
    }

    public void setAddress(AddressDTOOut address) {
        this.address = address;
    }
}
