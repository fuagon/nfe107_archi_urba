package net.cnam.nfe107.domain;

import net.cnam.nfe107.controller.dto.ToOrderRequest;
import net.cnam.nfe107.domain.entity.*;
import net.cnam.nfe107.repository.model.OrderProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderManagerService {

    @Autowired
    OrderManagerService orderManagerService;

    @Autowired
    ProductServiceUnit productServiceUnit;

    @Autowired
    CustomerServiceUnit customerServiceUnit;

    @Autowired
    OrderStatusServiceUnit orderStatusServiceUnit;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderServiceUnit orderServiceUnit;

    @Autowired
    OrderProductService orderProductService;

    /**
     * Créer commande
     */
    public Order createOrder(OrderToCreate orderToCreate)
    {
        Order order = orderService.create(orderToCreate);

        return order;
    }

    /**
     * Vérifie le stock sur le produit, puis l'ajoute si OK
     */
    public boolean addProductToOrder(Order order, Product product, Long quantity)
    {
        try {
            orderProductService.create(order, product, quantity);

            orderServiceUnit.updateOrderPrice(order.getIdOrder(), product.getPriceProduct() * quantity);

            return true;
        }
        catch(Exception exception) {
            return false;
        }
    }

    /**
     * Vérifie le stock pour un produit donné, et une quantité
     * @param product
     */
    public boolean verifyStockOnProduct(Product product, Long quantity)
    {
        return product.getStock() >= quantity;
    }

    public boolean toOrder(Order order, Long loyaltyPoints)
    {
        try
        {
            Float totalPrice = 0F;

            //On boucle parmi tous les produits de la commande
            for (OrderProductModel orderProductModel : order.getOrderProducts()) {
                //Étape 1 : On vérifie que la quantité demandée est supérieur au stock restant sur le produit
                boolean passed = orderManagerService.verifyStockOnProduct(new Product(orderProductModel.getProduct()), orderProductModel.getQuantity());
                if (passed) {
                    totalPrice += orderProductModel.getProduct().getPriceProduct() * orderProductModel.getQuantity();
                    totalPrice -= loyaltyPoints / 100;

                    //Étape 2 : On enlève la quantité demandée au stock restant
                    productServiceUnit.removeStock(orderProductModel.getProduct().getIdProduct(), orderProductModel.getQuantity());
                } else {
                    return false;
                }
            }

            //Étape 3 : On retire les X points de fidélité que le client choisi d'utiliser, si c'est le cas
            customerServiceUnit.removeLoyaltyPoints(order.getCustomer().getIdCustomer(), loyaltyPoints);

            //Étape 4 : On passe l'OrderStatus à 2, qui correspond à une commande payée
            orderStatusServiceUnit.changeOrderStatus(order, 2L);

            //Étape 5 : On crédite l'équivalent d'1% du prix de la commande en points de fidélité au Customer
            customerServiceUnit.addLoyaltyPoints(order.getCustomer().getIdCustomer(), (long) (totalPrice / 100F));

            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }
}