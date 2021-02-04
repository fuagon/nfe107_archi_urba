package net.cnam.nfe107.domain;

import net.cnam.nfe107.domain.entity.Customer;
import net.cnam.nfe107.domain.entity.CustomerToCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {


    @Autowired
    CustomerService customerService;

    /**
     * Routine suppression d'un utilisateur
     */
    public void deleteUser(Customer customer)
    {
        customerService.delete(customer.getIdCustomer());
    }


    /**
     * Ajouter des points de fidélité à un utilisateur
     */

    public void addLoyaltyPoints(Long idCustomer, Long loyaltyPoints) {
        Customer customer = customerService.getById(idCustomer);
        customer.setLoyaltyPoints(customer.getLoyaltyPoints() + loyaltyPoints);

        customerService.update(customer);
    }


    /**
     * Retirer des points de fidélité à un utilisateur
     */
    public void removeLoyaltyPoints(Long idCustomer, Long loyaltyPoints) {
        Customer customer = customerService.getById(idCustomer);

        if (customer.getLoyaltyPoints() >= loyaltyPoints)
        {
            customer.setLoyaltyPoints(customer.getLoyaltyPoints() - loyaltyPoints);
        }

        customerService.update(customer);
    }
}