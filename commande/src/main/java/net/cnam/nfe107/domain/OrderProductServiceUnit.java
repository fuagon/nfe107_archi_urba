package net.cnam.nfe107.domain;

import net.cnam.nfe107.domain.entity.OrderProduct;
import net.cnam.nfe107.domain.entity.crud.OrderProductService;
import net.cnam.nfe107.repository.OrderProductRepository;
import net.cnam.nfe107.repository.model.OrderProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if((orderProduct.getQuantity() - quantity) <= 0 ){
            orderProductService.delete(idOrder, idProduct);
        }else{
            orderProduct.setQuantity(orderProduct.getQuantity() - quantity);
            orderProductService.update(orderProduct);
        }

    }

    public Set<OrderProductModel> getProductsOrder(Long idOrder) {
        Set<OrderProductModel> list = new HashSet<OrderProductModel>();
        for (OrderProductModel o :orderProductService.getAllOrderProduct()) {
            if(o.getOrder().getIdOrder() == idOrder){
                list.add(o);
            }
        }
        if(list.stream().count() > 0){
            return list;
        }
        return  null;

    }

}
