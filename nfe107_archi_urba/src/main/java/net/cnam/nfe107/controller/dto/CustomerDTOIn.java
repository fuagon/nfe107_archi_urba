package net.cnam.nfe107.controller.dto;

/*
 * @created 29/10/2020/10/2020 - 17:54
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import net.cnam.nfe107.repository.model.Address;

import javax.persistence.*;

public class CustomerDTOIn {

    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String address;

    public CustomerDTOIn(String firstname, String lastname, String email, String phoneNumber, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

}

