package net.cnam.nfe107.controller.dto;

import java.util.ArrayList;

public class OrderProductResponseSmartList {

    private Long idOrder;

    //Contient le produit et sa quantité
    private ArrayList<OrderProductResponseWithoutIdOrder> products;

    public OrderProductResponseSmartList() {
    }

    public OrderProductResponseSmartList(Long idOrder, ArrayList<OrderProductResponseWithoutIdOrder> products) {
        this.idOrder = idOrder;
        this.products = products;
    }

    public Long getIdOrder() {
        return idOrder;
    }
    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }
    public ArrayList<OrderProductResponseWithoutIdOrder> getList() {
        return products;
    }
    public void setList(ArrayList<OrderProductResponseWithoutIdOrder> products) {
        this.products = products;
    }
}
