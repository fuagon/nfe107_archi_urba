package net.cnam.nfe107.repository.model;

/*
 * @created 29/10/2020/10/2020 - 10:22
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import org.springframework.lang.Nullable;

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
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "loyaltyPoints", nullable = false)
    private int loyaltyPoints;

    @OneToMany(mappedBy = "customer", targetEntity = AddressModel.class)
    private Set<AddressModel> addresses = new HashSet<>();

    @OneToMany (mappedBy = "customer", targetEntity = OrderModel.class)
    private Set<OrderModel> orders = new HashSet<>();


    public CustomerModel() {
    }
}
