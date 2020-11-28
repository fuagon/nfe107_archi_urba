package net.cnam.nfe107.domain;

/*
 * @created 29/10/2020/10/2020 - 10:56
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import net.cnam.nfe107.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Create

    // READ

    // UPDATE

    // DELETE




/*
    @Autowired
    private CustomerRepository customerRepository;

    // CREATE
    public ECustomer create(ECustomerToCreate eCustomerToCreate){

        Customer cToCreate = new Customer(eCustomerToCreate);
        Customer cCreated = customerRepository.save(cToCreate);
        return new ECustomer(cCreated);
    }

    // READ
    public List<ECustomer> getAll(){
        List<Customer> customersFound = customerRepository.findAll();
        List<ECustomer> eCustomers = new ArrayList<ECustomer>();
        for (Customer c:customersFound) {
            eCustomers.add(new ECustomer(c));
        }
        return eCustomers;
    }

    public ECustomer getById(Long id){
        Customer cFound = customerRepository.getOne(id);
        return new ECustomer(cFound);
    }

    // UPDATE
    public ECustomer update(ECustomer eCustomer){
        Customer c = new Customer(eCustomer);
        Customer cUpdate = customerRepository.save(c);
        return new ECustomer(cUpdate);
    }


    // DELETE
    public void delete (ECustomer eCustomer){
        customerRepository.delete(new Customer(eCustomer));
    }*/
}
