package net.cnam.nfe107.domain;

import net.cnam.nfe107.domain.entity.Address;
import net.cnam.nfe107.domain.entity.Customer;
import net.cnam.nfe107.domain.entity.Customer;
import net.cnam.nfe107.domain.entity.CustomerToCreate;
import net.cnam.nfe107.repository.CustomerRepository;
import net.cnam.nfe107.repository.model.AddressModel;
import net.cnam.nfe107.repository.model.CustomerModel;
import net.cnam.nfe107.repository.model.CustomerModel;
import net.cnam.nfe107.repository.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        List<CustomerModel> customersFromModel = customerRepository.findAll();
        ArrayList<Customer> customers = new ArrayList<>();

        for (CustomerModel customerModel:customersFromModel) {
            customers.add(new Customer(customerModel));
        }

        return customers;
    }

    public Customer getById(Long idCustomer) {
        CustomerModel customerModelFound = customerRepository.getOne(idCustomer);

        return new Customer(customerModelFound);
    }

    public Customer create(CustomerToCreate customerToCreate)
    {
        CustomerModel customerModelToCreate = new CustomerModel(customerToCreate);

        CustomerModel customerModelCreated = customerRepository.save(customerModelToCreate);

        return new Customer(customerModelCreated);
    }

    public Customer update(Customer customerToUpdate)
    {
        CustomerModel customerModel = new CustomerModel(customerToUpdate);

        CustomerModel customerModelUpdated = customerRepository.save(customerModel);

        return new Customer(customerModelUpdated);
    }

    public void delete(Long id)
    {
        customerRepository.deleteById(id);
    }
}
