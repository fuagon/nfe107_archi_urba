package net.cnam.nfe107.controller.dto;

import java.util.ArrayList;

public class OrderProductSmartListResponse {

    private Long idOrder;

    //Contient le produit et sa quantité
    private ArrayList<OrderProductWithoutIdOrderResponse> products;

    public OrderProductSmartListResponse() {
    }

    public OrderProductSmartListResponse(Long idOrder, ArrayList<OrderProductWithoutIdOrderResponse> products) {
        this.idOrder = idOrder;
        this.products = products;
    }

    public Long getIdOrder() {
        return idOrder;
    }
    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }
    public ArrayList<OrderProductWithoutIdOrderResponse> getProducts() {
        return products;
    }
    public void setProducts(ArrayList<OrderProductWithoutIdOrderResponse> products) {
        this.products = products;
    }
}
