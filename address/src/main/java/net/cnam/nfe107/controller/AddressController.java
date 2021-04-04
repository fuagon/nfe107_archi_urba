package net.cnam.nfe107.controller;

import net.cnam.nfe107.controller.dto.AddressRequest;
import net.cnam.nfe107.controller.dto.AddressResponse;
import net.cnam.nfe107.domain.AddressService;
import net.cnam.nfe107.domain.entity.Address;
import net.cnam.nfe107.domain.entity.AddressToCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/getAllAddresses")
    @ResponseBody
    public ResponseEntity<ArrayList<AddressResponse>> getAllAddresses() {
        List<Address> addressFound = addressService.getAllAddresses();
        ArrayList<AddressResponse> addressesResponse = new ArrayList<>();

        for (Address a:addressFound) {
            AddressResponse address = new AddressResponse(a);
            addressesResponse.add(address);
        }

        return new ResponseEntity<>(addressesResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<AddressResponse> getAddress(@PathVariable("id") Long id) {
        Address addressFound = addressService.getById(id);

        AddressResponse addressResponse = new AddressResponse(addressFound);

        return new ResponseEntity<>(addressResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<AddressResponse> createAddress(@RequestBody AddressRequest addressRequest) {
        AddressToCreate addressToCreate = new AddressToCreate(addressRequest);


        Address addressCreated = addressService.create(addressToCreate);

        AddressResponse addressResponse = new AddressResponse(addressCreated);

        return new ResponseEntity<>(addressResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<AddressResponse> updateAddress(@RequestBody AddressRequest addressRequest)
    {
        Address addressToUpdate = new Address(addressRequest);
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

    @GetMapping("/user/{id}")
    @ResponseBody
    public ResponseEntity<List<Address>> getAddressByUserID(@PathVariable("id") Long idUser)
    {
        List<Address> aList = addressService.getByUserId(idUser);

        if(aList != null)
            return new ResponseEntity<>(aList, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
