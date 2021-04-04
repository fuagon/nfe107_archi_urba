package net.cnam.nfe107.domain.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultatCreationAddress {
    public Long idAddress;
    public String country;
    public String city;
    public String postalCode;
    public String addressNumber;
    public String street;
    public Long idCustomer;

    @JsonCreator
    public ResultatCreationAddress(@JsonProperty("idAddress") Long idAddress, @JsonProperty("country") String country, @JsonProperty("city") String city,
                                   @JsonProperty("postalCode") String postalCode, @JsonProperty("addressNumber") String addressNumber,
                                   @JsonProperty("street") String street, @JsonProperty("idCustomer") Long idCustomer) {
        this.idAddress = idAddress;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.addressNumber = addressNumber;
        this.street = street;
        this.idCustomer = idCustomer;
    }
}
