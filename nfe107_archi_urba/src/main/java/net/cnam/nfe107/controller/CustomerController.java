package net.cnam.nfe107.controller;

import net.cnam.nfe107.controller.dto.*;
import net.cnam.nfe107.controller.dto.CustomerResponse;
import net.cnam.nfe107.domain.CustomerService;
import net.cnam.nfe107.domain.entity.Customer;
import net.cnam.nfe107.domain.entity.CustomerToCreate;
import net.cnam.nfe107.repository.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/getAllCustomers")
    @ResponseBody
    public ResponseEntity<ArrayList<CustomerResponse>> getAllCustomers() {

        List<CustomerModel> customerFound = customerService.getAllCustomers();
        ArrayList<CustomerResponse> customersResponse = new ArrayList<>();

        for (CustomerModel customer:customerFound) {
            CustomerResponse customer1 = new CustomerResponse(customer);
            customersResponse.add(customer1);
        }

        return new ResponseEntity<>(customersResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("id") Long id) {
        Customer customerFound = customerService.getById(id);

        CustomerResponse customerResponse = new CustomerResponse(customerFound);

        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerToCreate customerToCreate = new CustomerToCreate(customerRequest);

        Customer customerCreated = customerService.create(customerToCreate);

        CustomerResponse customerResponse = new CustomerResponse(customerCreated);

        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<CustomerResponse> updateCustomer(@RequestBody CustomerRequest customerRequest)
    {
        Customer customerToUpdate = new Customer(customerRequest);

        Customer customerUpdated = customerService.update(customerToUpdate);

        CustomerResponse customerResponse = new CustomerResponse(customerUpdated);

        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<CustomerResponse> deleteCustomer(@PathVariable("id") Long id)
    {
        customerService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
