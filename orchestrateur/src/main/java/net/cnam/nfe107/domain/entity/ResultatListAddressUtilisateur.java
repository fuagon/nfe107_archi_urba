package net.cnam.nfe107.domain.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.ArrayList;
import java.util.List;

public class ResultatListAddressUtilisateur {
    public ArrayList<ResultatCreationAddress> list;

    @JsonCreator
    public ResultatListAddressUtilisateur(ArrayList<ResultatCreationAddress> list) {
        this.list = list;
    }
}
