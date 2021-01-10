package net.cnam.nfe107.domain;

import net.cnam.nfe107.controller.dto.OrderRequest;
import net.cnam.nfe107.controller.dto.OrderResponse;
import net.cnam.nfe107.domain.entity.Order;
import net.cnam.nfe107.domain.entity.OrderStatus;
import net.cnam.nfe107.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@Transactional
@Service
public class OrderServiceUnit {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderStatusService orderStatusService;

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
}
