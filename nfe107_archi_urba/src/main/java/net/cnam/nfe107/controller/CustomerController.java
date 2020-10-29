package net.cnam.nfe107.controller;

/*
 * @created 29/10/2020/10/2020 - 11:23
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import net.cnam.nfe107.controller.dto.*;
import net.cnam.nfe107.domain.AddressService;
import net.cnam.nfe107.domain.CustomerService;
import net.cnam.nfe107.domain.entity.EAddress;
import net.cnam.nfe107.domain.entity.EAddressToCreate;
import net.cnam.nfe107.domain.entity.ECustomer;
import net.cnam.nfe107.domain.entity.ECustomerToCreate;
import net.cnam.nfe107.repository.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    AddressService addressService;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<CustomerDTOOut> create(@RequestBody CustomerDTOInWithId customerDTOIn){
        EAddress a = addressService.getById(3);
        ECustomerToCreate eCustomerToCreate = new ECustomerToCreate(customerDTOIn, new Address(a));
        ECustomer cCreated = customerService.create(eCustomerToCreate);
        return new ResponseEntity<CustomerDTOOut>(new CustomerDTOOut(cCreated), HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    @ResponseBody
    public List<CustomerDTOOut> getAll(){
        List<ECustomer> cFound = customerService.getAll();
        List<CustomerDTOOut> dtoOutCustomers = new ArrayList<>();
        for (ECustomer eC: cFound) {
            dtoOutCustomers.add(new CustomerDTOOut(eC));
        }
        return dtoOutCustomers;
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public ResponseEntity<CustomerDTOOut> getById(@PathVariable("id") long id){

        CustomerDTOOut dtoOutCustomer = new CustomerDTOOut(getECsutomerById(id));
        return new ResponseEntity<CustomerDTOOut>(dtoOutCustomer, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<CustomerDTOOut> update(@RequestBody CustomerDTOOut CustomerDTOOut){
        ECustomer toUpdate = new ECustomer(CustomerDTOOut);
        ECustomer eCustomerUpdate = customerService.update(toUpdate);
        return new ResponseEntity<CustomerDTOOut>(new CustomerDTOOut(eCustomerUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") long id){

        customerService.delete(getECsutomerById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private ECustomer getECsutomerById(long id){
        ECustomer cFound = customerService.getById(id);
        return cFound;
    }

}
