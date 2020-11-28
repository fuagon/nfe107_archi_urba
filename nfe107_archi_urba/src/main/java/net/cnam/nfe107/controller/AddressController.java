package net.cnam.nfe107.controller;

/*
 * @created 29/10/2020/10/2020 - 11:24
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import net.cnam.nfe107.domain.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {

    /*@Autowired
    AddressService addressService;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<AddressDTOOut> create(@RequestBody AddressDTOIn addressDTOIn){
        EAddressToCreate eAddressToCreate = new EAddressToCreate( addressDTOIn);
        EAddress aCreated = addressService.create(eAddressToCreate);
        return new ResponseEntity<AddressDTOOut>(new AddressDTOOut(aCreated), HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    @ResponseBody
    public List<AddressDTOOut> getAll(){
        List<EAddress> aFound = addressService.getAll();
        List<AddressDTOOut> dtoOutAddress = new ArrayList<>();
        for (EAddress eA: aFound) {
            dtoOutAddress.add(new AddressDTOOut(eA));
        }
        return dtoOutAddress;
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public ResponseEntity<AddressDTOOut> getById(@PathVariable("id") Long id){

        AddressDTOOut dtoOutAddress = new AddressDTOOut(getEAddressById(id));
        return new ResponseEntity<AddressDTOOut>(dtoOutAddress, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<AddressDTOOut> update(@RequestBody AddressDTOInWithId addressDTOOut){
        EAddress toUpdate = new EAddress(addressDTOOut);
        EAddress eAddressUpdate = addressService.update(toUpdate);
        return new ResponseEntity<AddressDTOOut>(new AddressDTOOut(eAddressUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){

        addressService.delete(getEAddressById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private EAddress getEAddressById(Long id){
        EAddress aFound = addressService.getById(id);
        return aFound;
    }

    */
}
