package net.cnam.nfe107.controller.dto;

import net.cnam.nfe107.domain.entity.Order;
import net.cnam.nfe107.domain.entity.OrderStatus;
import net.cnam.nfe107.domain.entity.Product;
import net.cnam.nfe107.repository.model.OrderProductModel;
import net.cnam.nfe107.repository.model.ProductModel;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.util.ArrayList;
import java.util.List;

public class OrderCompleteResponse {
    private Long idOrder;
    private Long idCustomer;
    private Long idAddress;
    private String date;
    private float priceOrder;
    private OrderStatus orderStatus;
    private List<ProductResponse> products;


    public OrderCompleteResponse(Order order){
        this.idOrder = order.getIdOrder();
        this.idCustomer = order.getIdCustomer();
        this.idAddress = order.getIdAddress();
        this.date = order.getDate();
        this.priceOrder = 0;
        this.orderStatus = order.getOrderStatus();

        var list = new ArrayList<ProductResponse>();
        if(order.getOrderProducts() != null){


        for (OrderProductModel op:order.getOrderProducts()) {
            var p = op.getProduct();
            list.add(new ProductResponse(p.getIdProduct(), p.getName(), p.getDescription(), p.getPriceProduct(), op.getQuantity()));
            this.priceOrder += p.getPriceProduct() * op.getQuantity();
        }
        this.products = list;
        }else
            this.products = null;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(float priceOrder) {
        this.priceOrder = priceOrder;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponse> products) {
        this.products = products;
    }
}
