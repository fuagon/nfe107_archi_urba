package net.cnam.nfe107.controller;

import net.cnam.nfe107.controller.dto.AddressRequest;
import net.cnam.nfe107.controller.dto.AddressResponse;
import net.cnam.nfe107.domain.AddressService;
import net.cnam.nfe107.domain.CustomerService;
import net.cnam.nfe107.domain.entity.Address;
import net.cnam.nfe107.domain.entity.AddressToCreate;
import net.cnam.nfe107.domain.entity.Customer;
import net.cnam.nfe107.repository.model.AddressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/getAllAddresses")
    @ResponseBody
    public ResponseEntity<ArrayList<AddressResponse>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        ArrayList<AddressResponse> addressesResponse = new ArrayList<>();

        for (Address address:addresses) {
            addressesResponse.add(new AddressResponse(address, address.getCustomer()));
        }

        return new ResponseEntity<>(addressesResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<AddressResponse> getAddress(@PathVariable("id") Long id) {
        Address address = addressService.getById(id);

        AddressResponse addressResponse = new AddressResponse(address, address.getCustomer());

        return new ResponseEntity<>(addressResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<AddressResponse> createAddress(@RequestBody AddressRequest addressRequest) {
        AddressToCreate addressToCreate = new AddressToCreate(addressRequest);

        Customer customer = customerService.getById(addressRequest.getIdCustomer());
        Address addressCreated = addressService.create(addressToCreate, customer);

        AddressResponse addressResponse = new AddressResponse(addressCreated, customer);

        return new ResponseEntity<>(addressResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<AddressResponse> updateAddress(@RequestBody AddressRequest addressRequest)
    {
        Customer customer = customerService.getById(addressRequest.getIdCustomer());
        Address addressToUpdate = new Address(addressRequest, customer);

        Address addressUpdated = addressService.update(addressToUpdate);

        AddressResponse addressResponse = new AddressResponse(addressUpdated);

        return new ResponseEntity<>(addressResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<AddressResponse> deleteAddress(@PathVariable("id") Long id)
    {
        addressService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
