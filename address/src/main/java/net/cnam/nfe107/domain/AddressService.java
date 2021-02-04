package net.cnam.nfe107.domain;

import net.cnam.nfe107.domain.entity.Address;
import net.cnam.nfe107.domain.entity.AddressToCreate;
import net.cnam.nfe107.repository.AddressRepository;
import net.cnam.nfe107.repository.model.AddressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        List<Address> addresses = new ArrayList<>();
        List<AddressModel> addressesFromModel = addressRepository.findAll();

        for (AddressModel addressModel:addressesFromModel) {
            addresses.add(new Address(addressModel));
        }

        return addresses;
    }

    public Address getById(Long idAddress) {
        AddressModel addressModelFound = addressRepository.getOne(idAddress);

        return new Address(addressModelFound);
    }

    public Address create(AddressToCreate addressToCreate)
    {

        AddressModel addressModelToCreate = new AddressModel(addressToCreate);

        AddressModel addressModelCreated = addressRepository.save(addressModelToCreate);

        return new Address(addressModelCreated);
    }

    public Address update(Address addressToUpdate)
    {

        AddressModel addressModel = new AddressModel(addressToUpdate);

        AddressModel addressModelUpdated = addressRepository.save(addressModel);

        return new Address(addressModelUpdated);
    }

    public void delete(Long id)
    {
        addressRepository.deleteById(id);
    }
}