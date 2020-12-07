package net.cnam.nfe107.domain;

import net.cnam.nfe107.controller.dto.AddressResponse;
import net.cnam.nfe107.domain.entity.Address;
import net.cnam.nfe107.domain.entity.AddressToCreate;
import net.cnam.nfe107.domain.entity.Customer;
import net.cnam.nfe107.repository.AddressRepository;
import net.cnam.nfe107.repository.model.AddressModel;
import net.cnam.nfe107.repository.model.CustomerModel;
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

    public Address create(AddressToCreate addressToCreate, Customer customer)
    {
        CustomerModel customerModel = new CustomerModel(customer);
        AddressModel addressModelToCreate = new AddressModel(addressToCreate, customerModel);

        AddressModel addressModelCreated = addressRepository.save(addressModelToCreate);

        return new Address(addressModelCreated);
    }

    public Address update(Address addressToUpdate)
    {
        CustomerModel customerModel = new CustomerModel(addressToUpdate.getCustomer());
        AddressModel addressModel = new AddressModel(addressToUpdate, customerModel);

        AddressModel addressModelUpdated = addressRepository.save(addressModel);

        return new Address(addressModelUpdated);
    }

    public void delete(Long id)
    {
        addressRepository.deleteById(id);
    }
}