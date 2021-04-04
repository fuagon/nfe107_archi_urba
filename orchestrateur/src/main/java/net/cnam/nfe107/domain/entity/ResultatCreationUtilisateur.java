package net.cnam.nfe107.domain.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultatCreationUtilisateur {
    public Long idCustomer;
    public String firstname;
    public String lastname;
    public String email;
    public String phoneNumber;
    public Long loyaltyPoints;

    @JsonCreator
    public ResultatCreationUtilisateur(@JsonProperty("idCustomer") Long idCustomer, @JsonProperty("firstname") String firstname, @JsonProperty("lastname") String lastname,
                                       @JsonProperty("email") String email, @JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("loyaltyPoints") Long loyaltyPoints) {
        this.idCustomer = idCustomer;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.loyaltyPoints = loyaltyPoints;
    }
}
