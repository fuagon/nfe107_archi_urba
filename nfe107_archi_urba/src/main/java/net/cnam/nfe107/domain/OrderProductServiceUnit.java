package net.cnam.nfe107.domain;

import net.cnam.nfe107.controller.dto.CustomerResponse;
import net.cnam.nfe107.controller.dto.LoyaltyPointsRequest;
import net.cnam.nfe107.controller.dto.OrderProductRequest;
import net.cnam.nfe107.controller.dto.OrderProductResponse;
import net.cnam.nfe107.domain.entity.Customer;
import net.cnam.nfe107.domain.entity.OrderProduct;
import net.cnam.nfe107.repository.CustomerRepository;
import net.cnam.nfe107.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderProductServiceUnit {

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private OrderProductService orderProductService;

    //Pour augmenter la quantité d'un produit dans une commande
    public void increaseQuantity(Long idOrder, Long idProduct, Long quantity) {
        OrderProduct orderProduct = orderProductService.getById(idOrder, idProduct);
        orderProduct.setQuantity(orderProduct.getQuantity() + quantity);

        orderProductService.update(orderProduct);
    }

    //Pour diminuer la quantité d'un produit dans une commande
    public void decreaseQuantity(Long idOrder, Long idProduct, Long quantity) {
        OrderProduct orderProduct = orderProductService.getById(idOrder, idProduct);
        orderProduct.setQuantity(orderProduct.getQuantity() - quantity);

        orderProductService.update(orderProduct);
    }
}
