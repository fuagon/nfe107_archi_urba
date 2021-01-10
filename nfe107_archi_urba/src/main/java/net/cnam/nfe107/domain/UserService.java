package net.cnam.nfe107.domain;

import net.cnam.nfe107.domain.entity.AddressToCreate;
import net.cnam.nfe107.domain.entity.Customer;
import net.cnam.nfe107.domain.entity.CustomerToCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    AddressService addressService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerServiceUnit customerServiceUnit;

    /**
     * Routine inscription d'un utilisateur
     */
    public void signUpUser(CustomerToCreate customerToCreate, AddressToCreate addressToCreate)
    {
        Customer customer = customerService.create(customerToCreate);
        customerServiceUnit.addLoyaltyPoints(customer.getIdCustomer(), 100L);
        addressService.create(addressToCreate, customer);
    }

    /**
     * Routine suppression d'un utilisateur
     */
    public void deleteUser(Customer customer)
    {
        customerService.delete(customer.getIdCustomer());
    }
}