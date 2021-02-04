package net.cnam.nfe107.domain;

import net.cnam.nfe107.domain.entity.Order;
import net.cnam.nfe107.domain.entity.OrderStatus;
import net.cnam.nfe107.domain.entity.OrderStatusToCreate;
import net.cnam.nfe107.repository.OrderStatusRepository;
import net.cnam.nfe107.repository.model.OrderStatusModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
