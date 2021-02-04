package net.cnam.nfe107.domain;

import net.cnam.nfe107.domain.entity.*;
import net.cnam.nfe107.repository.OrderRepository;
import net.cnam.nfe107.repository.OrderStatusRepository;
import net.cnam.nfe107.repository.model.CustomerModel;
import net.cnam.nfe107.repository.model.OrderModel;
import net.cnam.nfe107.repository.model.OrderStatusModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderStatusService {

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    public List<OrderStatusModel> getAllOrderStatus() {
        List<OrderStatusModel> orderStatus;

        orderStatus = orderStatusRepository.findAll();

        return orderStatus;
    }

    public OrderStatus getById(Long idOrderStatus) {
        OrderStatusModel orderStatusModelFound = orderStatusRepository.getOne(idOrderStatus);

        return new OrderStatus(orderStatusModelFound);
    }

    public OrderStatus create(OrderStatusToCreate orderStatusToCreate)
    {
        OrderStatusModel orderStatusModelToCreate = new OrderStatusModel(orderStatusToCreate);

        OrderStatusModel orderStatusModelCreated = orderStatusRepository.save(orderStatusModelToCreate);

        return new OrderStatus(orderStatusModelCreated);
    }

    public OrderStatus update(OrderStatus orderStatusToUpdate)
    {
        OrderStatusModel orderStatusModel = new OrderStatusModel(orderStatusToUpdate);

        OrderStatusModel orderStatusModelUpdated = orderStatusRepository.save(orderStatusModel);

        return new OrderStatus(orderStatusModelUpdated);
    }

    public void delete(Long id)
    {
        orderStatusRepository.deleteById(id);
    }
}
