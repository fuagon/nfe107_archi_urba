package net.cnam.nfe107.domain.entity.crud;

import net.cnam.nfe107.domain.OrderProductServiceUnit;
import net.cnam.nfe107.domain.entity.*;
import net.cnam.nfe107.domain.entity.Order;
import net.cnam.nfe107.repository.OrderRepository;
import net.cnam.nfe107.repository.model.*;
import net.cnam.nfe107.repository.model.OrderModel;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProductServiceUnit productServiceUnit;

    public List<OrderModel> getAllOrders() {
        List<OrderModel> orders;

        orders = orderRepository.findAll();

        return orders;
    }

    public Order getById(Long idOrder) throws EntityNotFoundException {
        OrderModel orderModelFound;

        orderModelFound = orderRepository.getOne(idOrder);


        //OrderStatus orderStatus = new OrderStatus(orderModelFound.getOrderStatus());

        if(orderModelFound.getIdOrder() != null){


            var o =new Order(orderModelFound);
            var list = productServiceUnit.getProductsOrder(idOrder);
            o.setOrderProducts(list);
            return o;
        }else{
            return null;
        }

    }

    public Order create(OrderToCreate orderToCreate)
    {
        OrderStatusModel orderStatusModel = new OrderStatusModel(orderToCreate.getOrderStatus());
        OrderModel orderModelToCreate = new OrderModel(orderToCreate, orderStatusModel);

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

    public Set<OrderProductModel> getOrdersProduct(Long idOrder)
    {
        var u = orderRepository.getOne(idOrder);
        OrderModel orderModel = u;
        return orderModel.getOrdersProducts();
    }
}