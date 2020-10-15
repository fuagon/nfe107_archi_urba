package net.cnam.nfe107.controller.dto;

/*
 * @created 15/10/2020/10/2020 - 20:54
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

/**
 * DTO Response for Mouse
 */
public class MouseResponse {
    private int id;
    private String name;
    private Boolean male;

    public MouseResponse() {
    }

    public MouseResponse(int id, String name, Boolean male) {
        this.id = id;
        this.name = name;
        this.male = male;
    }

    public MouseResponse(MouseRequest mouseRequest) {
        this.id = mouseRequest.getId();
        this.name = mouseRequest.getName();
        this.male = mouseRequest.getMale();
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
        return male;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }
}
