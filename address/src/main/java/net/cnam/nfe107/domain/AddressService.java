package net.cnam.nfe107.domain;

import net.cnam.nfe107.domain.entity.Address;
import net.cnam.nfe107.domain.entity.AddressToCreate;
import net.cnam.nfe107.repository.AddressRepository;
import net.cnam.nfe107.repository.model.AddressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
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

    public List<Address> getByUserId(Long idUser) {

        var addresses = getAllAddresses();
        var adressesUser = new ArrayList<Address>();
        for (Address a:addresses) {
            if(a.getIdCustomer() == idUser){
                adressesUser.add(a);
            }
        }
        return adressesUser;
    }

    public Address create(AddressToCreate addressToCreate)
    {

        AddressModel addressModelToCreate = new AddressModel(addressToCreate);

        AddressModel addressModelCreated = addressRepository.save(addressModelToCreate);

        return new Address(addressModelCreated);
    }

    public Address update(Address addressToUpdate)
    {
        var address = addressRepository.getOne(addressToUpdate.getIdAddress());
        address.setCountry(addressToUpdate.getCountry());
        address.setCity(addressToUpdate.getCity());
        address.setPostalCode(addressToUpdate.getPostalCode());
        address.setAddressNumber(addressToUpdate.getAddressNumber());
        address.setStreet(addressToUpdate.getStreet());
        address.setIdCustomer(addressToUpdate.getIdCustomer());
        AddressModel addressModelUpdated = addressRepository.save(address);

        return new Address(addressModelUpdated);
    }

    public void delete(Long id)
    {
        addressRepository.deleteById(id);
    }
}