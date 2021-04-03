package net.cnam.nfe107.domain;

import net.cnam.nfe107.domain.entity.Order;
import net.cnam.nfe107.domain.entity.OrderStatus;
import net.cnam.nfe107.domain.entity.crud.OrderService;
import net.cnam.nfe107.domain.entity.crud.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service
public class OrderServiceUnit {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderStatusService orderStatusService;

    @Autowired
    ProductServiceUnit productServiceUnit;

    @Autowired
    OrderStatusServiceUnit orderStatusServiceUnit;

    //Mettre à jour le statut d'une commande
    public void updateOrderStatus(Long idOrder, Long idOrderStatus) {
        Order order = orderService.getById(idOrder);
        OrderStatus orderStatus = orderStatusService.getById(idOrderStatus);
        order.setOrderStatus(orderStatus);

        orderService.update(order);
    }

    //Mettre à jour le prix d'une commande
    public void updateOrderPrice(Long idOrder, Float price) {
        Order order = orderService.getById(idOrder);
        order.setPriceOrder(order.getPriceOrder() + price);

        orderService.update(order);
    }


    //Mettre à jour le prix d'une commande
    public Order validateCommande(Long idOrder) {
        Order order;
        try{
            order = orderService.getById(idOrder);
        }catch (EntityNotFoundException exception){
            order = null;
        }
        if(order != null){
            if(order.getOrderProducts() != null){
                for (var p:order.getOrderProducts()) {
                    if(productServiceUnit.checkSufficientQuantity(p.getProduct().getIdProduct(), p.getQuantity())){
                        productServiceUnit.removeStock(p.getProduct().getIdProduct(), p.getQuantity());
                    }else{
                        return  null;
                    }
                }
                orderStatusServiceUnit.changeOrderStatus(order, Long.valueOf(2));

                return orderService.getById(idOrder);
            }
        }
        return null;
    }

}
