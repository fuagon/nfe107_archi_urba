package net.cnam.nfe107.domain;

import net.cnam.nfe107.controller.dto.CreerCommandeResponse;
import net.cnam.nfe107.controller.dto.ValidateCommandeResponse;
import net.cnam.nfe107.domain.dto.AddProductCommande;
import net.cnam.nfe107.domain.dto.CreateAddressRequest;
import net.cnam.nfe107.domain.dto.CreateCommandeRequest;
import net.cnam.nfe107.domain.dto.CreateCustomerRequest;
import net.cnam.nfe107.domain.entity.*;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ShopService {
    private final static String creerUtilsateur = "http://localhost:8082/api/customer/create";
    private final static String creerAddress = "http://localhost:8081/api/address/create";

    private final static String supprimerUtilsateur = "http://localhost:8082/api/customer/delete/";
    private final static String supprimerAddressUtilisateur = "http://localhost:8081/api/address/";

    private final static String listAddressUtilisateur = "http://localhost:8081/api/address/user/";

    private final static String commandeACreerurl = "http://localhost:8083/api/commande/creer";
    private final static String commandeAjouterProduit = "http://localhost:8083/api/commande/ajouterProduitCommande";
    private final static String commandeSupprimerProduit = "http://localhost:8083/api/commande/supprimerProduitCommande";
    private final static String validerCommande = "http://localhost:8083/api/commande/validerCommande";


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

    public ResultatCreationAddress[] recupererAdressesUtilisateur(Long idCustomer){
        RestTemplate restTemplate = new RestTemplate();
        String url = listAddressUtilisateur + idCustomer.toString();

        ResultatCreationAddress[] r = restTemplate.getForObject(url,
                ResultatCreationAddress[].class);

        return  r;
    }

    public void deleteAddress(Long idAddress) {
        RestTemplate restTemplate = new RestTemplate();
        String url = supprimerAddressUtilisateur + idAddress.toString();
        restTemplate.delete(url);

    }

    public void deleteCustomer(Long idCustomer) {
        RestTemplate restTemplate = new RestTemplate();
        String url = supprimerUtilsateur + idCustomer.toString();
        restTemplate.delete(url);
    }

    public CreerCommandeResponse creerCommande(CommandeACreer commandeACreer) {
        // Créer utilisateur
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CreateCommandeRequest> createCustomerRequestHttpEntity = new HttpEntity<>(new CreateCommandeRequest(
                commandeACreer.getDate(),commandeACreer.getIdCustomer(), commandeACreer.getIdAddress(), commandeACreer.getIdProduct(), commandeACreer.getQuantity()));

        CreerCommandeResponse resultatCreationCommande = restTemplate.postForObject(commandeACreerurl, createCustomerRequestHttpEntity, CreerCommandeResponse.class);

        return resultatCreationCommande;
    }

    public CreerCommandeResponse ajouterProduitsCommande(AddProductCommande addProductCommandeRequest) {
        // Créer utilisateur
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<AddProductCommande> addProductCommandeRequestHttpEntity = new HttpEntity<>(addProductCommandeRequest);

        CreerCommandeResponse resultatCreationCommande = restTemplate.postForObject(commandeAjouterProduit, addProductCommandeRequestHttpEntity, CreerCommandeResponse.class);

        return resultatCreationCommande;
    }

    public CreerCommandeResponse supprimerProduitsCommande(AddProductCommande addProductCommande) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<AddProductCommande> addProductCommandeRequestHttpEntity = new HttpEntity<>(addProductCommande);

        CreerCommandeResponse resultatCreationCommande = restTemplate.postForObject(commandeSupprimerProduit, addProductCommandeRequestHttpEntity, CreerCommandeResponse.class);

        return resultatCreationCommande;
    }

    public ValidateCommandeResponse validateCommande(CommandeAValider commandeAValider) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CommandeAValider> createCustomerRequestHttpEntity = new HttpEntity<>(commandeAValider);

        ValidateCommandeResponse resultatCreationCommande = restTemplate.postForObject(validerCommande, createCustomerRequestHttpEntity, ValidateCommandeResponse.class);

        return resultatCreationCommande;
    }

    public boolean paiment(CommandeAValider commandeAValider) {

        // SIMULER UN PAIEMENT
        return true;
    }

    public void livrer(CommandeAValider commandeAValider) {
        // Simule la mise en livraison
    }
}
