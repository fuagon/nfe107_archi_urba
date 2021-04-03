package net.cnam.nfe107.domain;

import net.cnam.nfe107.domain.entity.OrderProduct;
import net.cnam.nfe107.domain.entity.crud.OrderProductService;
import net.cnam.nfe107.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderProductServiceUnit {
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
