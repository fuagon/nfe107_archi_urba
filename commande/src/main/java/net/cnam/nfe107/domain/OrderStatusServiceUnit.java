package net.cnam.nfe107.domain;

import net.cnam.nfe107.domain.entity.Order;
import net.cnam.nfe107.domain.entity.crud.OrderService;
import net.cnam.nfe107.domain.entity.crud.OrderStatusService;
import net.cnam.nfe107.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderStatusServiceUnit {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderStatusService orderStatusService;

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    public void changeOrderStatus(Order order, Long idOrderStatus) {
        order.setOrderStatus(orderStatusService.getById(idOrderStatus));

        orderService.update(order);
    }
}
