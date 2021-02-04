package net.cnam.nfe107.domain;

import net.cnam.nfe107.controller.CustomerController;
import net.cnam.nfe107.domain.entity.*;
import net.cnam.nfe107.domain.entity.Order;
import net.cnam.nfe107.repository.OrderRepository;
import net.cnam.nfe107.repository.model.*;
import net.cnam.nfe107.repository.model.OrderModel;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderModel> getAllOrders() {
        List<OrderModel> orders;

        orders = orderRepository.findAll();

        return orders;
    }

    public Order getById(Long idOrder) {
        OrderModel orderModelFound = orderRepository.getOne(idOrder);
        Customer customer = new Customer(orderModelFound.getCustomer());
        Address address = new Address(orderModelFound.getAddress());
        OrderStatus orderStatus = new OrderStatus(orderModelFound.getOrderStatus());

        return new Order(orderModelFound, customer, address, orderStatus);
    }

    public Order create(OrderToCreate orderToCreate)
    {
        CustomerModel customerModel = new CustomerModel(orderToCreate.getCustomer());
        AddressModel addressModel = new AddressModel(orderToCreate.getAddress());
        OrderStatusModel orderStatusModel = new OrderStatusModel(orderToCreate.getOrderStatus());
        OrderModel orderModelToCreate = new OrderModel(orderToCreate, customerModel, addressModel, orderStatusModel);

        OrderModel orderModelCreated = orderRepository.save(orderModelToCreate);

        return new Order(orderModelCreated);
    }

    public Order update(Order orderToUpdate)
    {
        OrderModel orderModel = new OrderModel(orderToUpdate);

        OrderModel orderModelUpdated = orderRepository.save(orderModel);

        return new Order(orderModelUpdated);
    }

    public void delete(Long id)
    {
        orderRepository.deleteById(id);
    }

    public Set<OrderProductModel> getOrdersProduct(Order order)
    {
        OrderModel orderModel = new OrderModel(order);
        return orderModel.getOrdersProducts();
    }
}