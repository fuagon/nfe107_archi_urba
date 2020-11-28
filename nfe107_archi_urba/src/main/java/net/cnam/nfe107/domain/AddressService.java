package net.cnam.nfe107.domain;

/*
 * @created 29/10/2020/10/2020 - 10:57
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AddressService {
/*
    @Autowired
    private AddressRepository addressRepository;

    // CREATE
    public EAddress create(EAddressToCreate eAddressToCreate){

        AddressModel aToCreate = new AddressModel(eAddressToCreate);
        AddressModel aCreated = addressRepository.save(aToCreate);
        return new EAddress(aCreated);
    }

    // READ
    public List<EAddress> getAll(){
        List<AddressModel> addressesFound = addressRepository.findAll();
        List<EAddress> eAddresses = new ArrayList<EAddress>();
        for (AddressModel a:addressesFound) {
            eAddresses.add(new EAddress(a));
        }
        return eAddresses;
    }

    public EAddress getById(Long id){
        AddressModel aFound = addressRepository.getOne(id);
        return new EAddress(aFound);
    }

    // UPDATE
    public EAddress update(EAddress eAddress){
        AddressModel a = new AddressModel(eAddress);
        AddressModel aUpdate = addressRepository.save(a);
        return new EAddress(aUpdate);
    }


    // DELETE
    public void delete (EAddress eAddress){
        addressRepository.delete(new AddressModel(eAddress));
    }
*/
}
