package net.cnam.nfe107.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoyaltyPointRequest {
    public Long nbPoint;
    public Long idUser;


    @JsonCreator
    public LoyaltyPointRequest(@JsonProperty("nbPoint") Long nbPoint,
                                 @JsonProperty("idUser") Long idUser) {
        this.nbPoint = nbPoint;
        this.idUser = idUser;
    }
}
