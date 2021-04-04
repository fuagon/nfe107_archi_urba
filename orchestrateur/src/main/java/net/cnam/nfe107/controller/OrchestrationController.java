package net.cnam.nfe107.controller;

/*
 * @created 04/02/2021/02/2021 - 14:34
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import net.cnam.nfe107.controller.dto.*;
import net.cnam.nfe107.domain.ShopService;
import net.cnam.nfe107.domain.dto.AddProductCommande;
import net.cnam.nfe107.domain.dto.CreateAddressRequest;
import net.cnam.nfe107.domain.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class OrchestrationController {

    @Autowired
    private ShopService shopService;


    @PostMapping("/creerUtilisateur")
    @ResponseBody
    public ResponseEntity<CreerUtilisateurResponse> creerUnUtilisateurEtSonAdresse(@RequestBody CreerUtilisateurRequest creerUtilisateurRequest) {

        // On convertit notre contrat de service de type Request vers notre objet métier.
        UtilisateurACreer utilisateurACreer = new UtilisateurACreer(creerUtilisateurRequest.getFirstname(),
                creerUtilisateurRequest.getLastname(),creerUtilisateurRequest.getEmail(),
                creerUtilisateurRequest.getPhoneNumber(), Long.valueOf(100), creerUtilisateurRequest.getCountry(),
                creerUtilisateurRequest.getCity(), creerUtilisateurRequest.getPostalCode(),
                creerUtilisateurRequest.getAddressNumber(), creerUtilisateurRequest.getStreet());

        // Etape 2 : On appelle notre service d'orchestration métier
        // créer utilisateur
        ResultatCreationUtilisateur resultatCreationUtilisateur = shopService.creerUnUtilisateur(utilisateurACreer);
        // créer address
        ResultatCreationAddress resultatCreationAddress = shopService.creerUneAddress(resultatCreationUtilisateur.idCustomer, utilisateurACreer);


        // Etape 3 : On convertit notre réponse métier vers notre contrat de service de type response
        CreerUtilisateurResponse creerUtilisateurResponse = new CreerUtilisateurResponse(resultatCreationUtilisateur.idCustomer,
                resultatCreationUtilisateur.firstname, resultatCreationUtilisateur.lastname, resultatCreationUtilisateur.email,
                resultatCreationUtilisateur.phoneNumber, resultatCreationAddress.idAddress, resultatCreationAddress.country, resultatCreationAddress.city,
                resultatCreationAddress.postalCode, resultatCreationAddress.addressNumber, resultatCreationAddress.street);

        // Etape 4 : On constitue et envoie notre réponse HTTP
        return new ResponseEntity<>(creerUtilisateurResponse, HttpStatus.OK);
    }

    @DeleteMapping("/supprimerUtilisateurRGPD/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteUserRGPD(@PathVariable("id") Long idUtilsateur){

        // On récupère la totalité des addres de l'utilisateur
        var a = shopService.recupererAdressesUtilisateur(idUtilsateur);
        for (var o: a) {
            // On les supprime tous
            shopService.deleteAddress(o.idAddress);
        }
        // On fini en supprimant l'utilsateur egalement
        shopService.deleteCustomer(idUtilsateur);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/ajoutAddress")
    @ResponseBody
    public ResponseEntity<ResultatCreationAddress> ajoutAdress(@RequestBody CreateAddressRequest addressRequest){

        // Creation de l'adresse
        var res = shopService.creerUneAddress(addressRequest.getIdCustomer(), new UtilisateurACreer("","", "",
            "", null, addressRequest.getCountry(), addressRequest.getCity(),
            addressRequest.getPostalCode(), addressRequest.getAddressNumber(), addressRequest.getStreet()));

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/creerCommande")
    @ResponseBody
    public ResponseEntity<CreerCommandeResponse> creerCommande(@RequestBody CreerCommandeRequest commandeRequest){

        // Etape 1 : On convertit notre contrat de service de type Request vers notre objet métier.
        CommandeACreer commandeACreer = new CommandeACreer(commandeRequest.getDate(), commandeRequest.getIdCustomer(),
                commandeRequest.getIdAddress(), commandeRequest.getIdProduct(), commandeRequest.getQuantite());

        // Etape 2 : On appelle notre service d'orchestration métier
        CreerCommandeResponse resultatCreationCommande = shopService.creerCommande(commandeACreer);


        // Etape 3 : On constitue et envoie notre réponse HTTP
        return new ResponseEntity<>(resultatCreationCommande, HttpStatus.OK);
    }


    @PostMapping("/ajouterProduitCommande")
    @ResponseBody
    public ResponseEntity<CreerCommandeResponse> addProducts(@RequestBody AjouterProduitCommande commandeRequest){

        // Etape 1 : On convertit notre contrat de service de type Request vers notre objet métier.
        AddProductCommande addProductCommande = new AddProductCommande(commandeRequest.getIdOrder(),
                commandeRequest.getIdProduct(), commandeRequest.getQuantity());

        // Etape 2 : On appelle notre service d'orchestration métier
        CreerCommandeResponse resultatCreationCommande = shopService.ajouterProduitsCommande(addProductCommande);

        // Etape 3 : On constitue et envoie notre réponse HTTP
        return new ResponseEntity<>(resultatCreationCommande, HttpStatus.OK);
    }

    @PostMapping("/supprimerProduitCommande")
    @ResponseBody
    public ResponseEntity<CreerCommandeResponse> delProducts(@RequestBody AjouterProduitCommande ajouterProduitCommande){

        // Etape 1 : On convertit notre contrat de service de type Request vers notre objet métier.
        AddProductCommande addProductCommande = new AddProductCommande(ajouterProduitCommande.getIdOrder(),
                ajouterProduitCommande.getIdProduct(), ajouterProduitCommande.getQuantity());

        // Etape 2 : On appelle notre service d'orchestration métier
        CreerCommandeResponse resultatCreationCommande = shopService.supprimerProduitsCommande(addProductCommande);

        // Etape 3 : On constitue et envoie notre réponse HTTP
        return new ResponseEntity<>(resultatCreationCommande, HttpStatus.OK);
    }




    @PostMapping("/validateCommande")
    @ResponseBody
    public ResponseEntity<ValidateCommandeResponse> validateCommande(@RequestBody ValidateCommandeRequest commandeRequest){

        // Etape 1 : On convertit notre contrat de service de type Request vers notre objet métier.
        CommandeAValider commandeAValider = new CommandeAValider(
                commandeRequest.getIdOrder(),
                commandeRequest.getFidelityPointUsed(),
                commandeRequest.getCardNumber(),
                commandeRequest.getCardName(),
                commandeRequest.getCvc2()
        );

        // Etape 2 : Tentative de paiement si le paiement s'execute correctement on valide alors la commande
        if(shopService.paiment(commandeAValider)){
            ValidateCommandeResponse resultatCreationCommande = shopService.validateCommande(commandeAValider);
            shopService.livrer(commandeAValider);
            //Etape 3 : On constitue et envoie notre réponse HTTP
            return new ResponseEntity<>(resultatCreationCommande, HttpStatus.OK);
        }

        //Etape 3(bis) : On constitue et envoie notre réponse HTTP
        return new ResponseEntity<>(HttpStatus.CONFLICT);

    }

}
