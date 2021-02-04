package net.cnam.nfe107.repository.model;

import net.cnam.nfe107.domain.entity.Customer;
import net.cnam.nfe107.domain.entity.CustomerToCreate;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="table_customer")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long idCustomer;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "loyalty_points", columnDefinition = "integer default 0")
    private Long loyaltyPoints;

    @OneToMany(mappedBy = "customer", targetEntity = AddressModel.class, cascade = CascadeType.ALL)
    private Set<AddressModel> addresses = new HashSet<>();

    @OneToMany(mappedBy = "customer", targetEntity = OrderModel.class, cascade = CascadeType.ALL)
    private Set<OrderModel> orders = new HashSet<>();
    // GET ALLORDER BY IDUSer

    public CustomerModel() {
    }

    public CustomerModel(Long idCustomer, String firstname, String lastname, String email, String phoneNumber, Long loyaltyPoints) {
        this.idCustomer = idCustomer;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.loyaltyPoints = loyaltyPoints;
    }

    public CustomerModel(Customer customer)
    {
        this.idCustomer = customer.getIdCustomer();
        this.firstname = customer.getFirstname();
        this.lastname = customer.getLastname();
        this.email = customer.getEmail();
        this.phoneNumber = customer.getPhoneNumber();
        this.loyaltyPoints = customer.getLoyaltyPoints();
    }

    public CustomerModel(CustomerToCreate customerToCreate)
    {
        this.firstname = customerToCreate.getFirstname();
        this.lastname = customerToCreate.getLastname();
        this.email = customerToCreate.getEmail();
        this.phoneNumber = customerToCreate.getPhoneNumber();
        this.loyaltyPoints = customerToCreate.getLoyaltyPoints();
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
