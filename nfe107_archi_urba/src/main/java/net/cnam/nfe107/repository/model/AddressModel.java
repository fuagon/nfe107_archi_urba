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
@Table(name="table_address")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "addressNumber")
    private String addressNumber;

    @Column(name = "street")
    private String street;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private CustomerModel customer;

    @OneToMany(mappedBy = "address", targetEntity = OrderModel.class)
    @Nullable
    private Set<OrderModel> orders = new HashSet<>();

    public AddressModel() {
    }
}
