package net.cnam.nfe107.domain;

/*
 * @created 29/10/2020/10/2020 - 10:57
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import net.cnam.nfe107.domain.entity.EAddress;
import net.cnam.nfe107.domain.entity.EAddressToCreate;
import net.cnam.nfe107.repository.AddressRepository;
import net.cnam.nfe107.repository.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    // CREATE
    public EAddress create(EAddressToCreate eAddressToCreate){

        Address aToCreate = new Address(eAddressToCreate);
        Address aCreated = addressRepository.save(aToCreate);
        return new EAddress(aCreated);
    }

    // READ
    public List<EAddress> getAll(){
        List<Address> addressesFound = addressRepository.findAll();
        List<EAddress> eAddresses = new ArrayList<EAddress>();
        for (Address a:addressesFound) {
            eAddresses.add(new EAddress(a));
        }
        return eAddresses;
    }

    public EAddress getById(Long id){
        Address aFound = addressRepository.getOne(id);
        return new EAddress(aFound);
    }

    // UPDATE
    public EAddress update(EAddress eAddress){
        Address a = new Address(eAddress);
        Address aUpdate = addressRepository.save(a);
        return new EAddress(aUpdate);
    }


    // DELETE
    public void delete (EAddress eAddress){
        addressRepository.delete(new Address(eAddress));
    }

}
