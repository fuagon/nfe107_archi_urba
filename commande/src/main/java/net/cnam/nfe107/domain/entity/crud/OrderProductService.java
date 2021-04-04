package net.cnam.nfe107.domain.entity.crud;

import net.cnam.nfe107.domain.entity.*;
import net.cnam.nfe107.repository.OrderProductRepository;
import net.cnam.nfe107.repository.OrderRepository;
import net.cnam.nfe107.repository.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    public List<OrderProductModel> getAllOrderProduct() {
        List<OrderProductModel> orderProducts;

        orderProducts = orderProductRepository.findAll();

        return orderProducts;
    }

    public OrderProduct getById(Long idOrder, Long idProduct) {
        OrderProductIdModel orderProductIdModel = new OrderProductIdModel(idOrder, idProduct);
        OrderProductModel orderProductModelFound = orderProductRepository.getOne(orderProductIdModel);

        return new OrderProduct(orderProductModelFound);
    }

    public OrderProduct getById(Long idOrder) {
        OrderProductIdModel orderProductIdModel = new OrderProductIdModel(idOrder, null);
        OrderProductModel orderProductModelFound = orderProductRepository.getOne(orderProductIdModel);

        return new OrderProduct(orderProductModelFound);
    }

    public OrderProduct create(Order order, Product product, Long quantity)
    {
        OrderModel orderModel = new OrderModel(order);
        ProductModel productModel = new ProductModel(product);
        OrderProductModel orderProductModelToCreate = new OrderProductModel(orderModel, productModel, quantity);
        OrderProductModel orderProductModelCreated = orderProductRepository.save(orderProductModelToCreate);

        return new OrderProduct(orderProductModelCreated);
    }

    public OrderProduct update(OrderProduct orderProductToUpdate)
    {
        OrderProductModel orderProductModel = new OrderProductModel(orderProductToUpdate);
        OrderProductModel orderProductModelUpdated = orderProductRepository.save(orderProductModel);

        return new OrderProduct(orderProductModelUpdated);
    }

    public void delete(Long idOrder, Long idProduct)
    {
        OrderProductIdModel orderProductIdModel = new OrderProductIdModel(idOrder, idProduct);

        orderProductRepository.deleteById(orderProductIdModel);
    }
}