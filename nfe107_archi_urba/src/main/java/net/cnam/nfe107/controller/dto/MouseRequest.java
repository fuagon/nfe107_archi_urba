package net.cnam.nfe107.controller.dto;

/*
 * @created 15/10/2020/10/2020 - 20:54
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

/**
 * DTO Request for Mouse
 */
public class MouseRequest {
    private int id;
    private String name;
    private Boolean isMale;

    public MouseRequest() {
    }

    public MouseRequest(int id, String name, Boolean isMale) {
        this.id = id;
        this.name = name;
        this.isMale = isMale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getMale() {
        return isMale;
    }

    public void setMale(Boolean male) {
        isMale = male;
    }
}
