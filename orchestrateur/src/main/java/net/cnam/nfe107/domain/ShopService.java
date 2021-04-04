package net.cnam.nfe107.domain;

import net.cnam.nfe107.domain.dto.CreateAddressRequest;
import net.cnam.nfe107.domain.dto.CreateCustomerRequest;
import net.cnam.nfe107.domain.entity.ResultatCreationAddress;
import net.cnam.nfe107.domain.entity.ResultatCreationUtilisateur;
import net.cnam.nfe107.domain.entity.UtilisateurACreer;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Service
@Transactional
public class ShopService {
    private final static String creerUtilsateur = "http://localhost:8082/api/customer/create";
    private final static String creerAddress = "http://localhost:8081/api/address/create";


    public ResultatCreationUtilisateur creerUnUtilisateur(UtilisateurACreer userAddress){

        // Créer utilisateur
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CreateCustomerRequest> createCustomerRequestHttpEntity = new HttpEntity<>(new CreateCustomerRequest(
                userAddress.getFirstname(),
                userAddress.getLastname(),
                userAddress.getEmail(),
                userAddress.getPhoneNumber()));

        ResultatCreationUtilisateur resultatCreationUtilisateur = restTemplate.postForObject(creerUtilsateur, createCustomerRequestHttpEntity,
                ResultatCreationUtilisateur.class);

        return resultatCreationUtilisateur;
    }

    public ResultatCreationAddress creerUneAddress(Long idCustomer, UtilisateurACreer userAddress){

        // Créer address
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CreateAddressRequest> createAddressRequestHttpEntity = new HttpEntity<>(new CreateAddressRequest(userAddress.getCountry(),
                userAddress.getCity(),
                userAddress.getPostalCode(),
                userAddress.getAddressNumber(),
                userAddress.getStreet(),
                idCustomer));

        ResultatCreationAddress resultatCreationAddress = restTemplate.postForObject(creerAddress, createAddressRequestHttpEntity,
                ResultatCreationAddress.class);

        return resultatCreationAddress;
    }

}
