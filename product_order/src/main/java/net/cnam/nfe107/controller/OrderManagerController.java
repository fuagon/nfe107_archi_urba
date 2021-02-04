package net.cnam.nfe107.controller;

import net.bytebuddy.implementation.bytecode.Throw;
import net.cnam.nfe107.controller.dto.AddProductToOrderRequest;
import net.cnam.nfe107.controller.dto.SignUpRequest;
import net.cnam.nfe107.controller.dto.ToOrderRequest;
import net.cnam.nfe107.domain.*;
import net.cnam.nfe107.domain.entity.*;
import net.cnam.nfe107.repository.model.OrderProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderManager")
public class OrderManagerController {

    @Autowired
    OrderManagerService orderManagerService;

    @Autowired
    ProductService productService;

    @Autowired
    CustomerService customerService;

    @Autowired
    AddressService addressService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderStatusService orderStatusService;

    @RequestMapping("/create")
    public ResponseEntity<?> create(@RequestBody AddProductToOrderRequest addProductToOrderRequest)
    {
        Customer customer = customerService.getById(addProductToOrderRequest.getIdCustomer());
        Address address = addressService.getById(addProductToOrderRequest.getIdAddress());
        OrderStatus orderStatus = orderStatusService.getById(addProductToOrderRequest.getIdOrderStatus());
        Product product = productService.getById(addProductToOrderRequest.getIdProduct());

        OrderToCreate orderToCreate = new OrderToCreate(addProductToOrderRequest, customer, address, orderStatus);

        Order order = orderManagerService.createOrder(orderToCreate);

        orderManagerService.addProductToOrder(order, product, addProductToOrderRequest.getQuantity());

        return ResponseEntity.status(200).build();
    }

    @RequestMapping("/addProductToOrder")
    public ResponseEntity<?> addProductToOrder(@RequestBody AddProductToOrderRequest addProductToOrderRequest)
    {
        Order order = orderService.getById(addProductToOrderRequest.getIdOrder());
        Product product = productService.getById(addProductToOrderRequest.getIdProduct());
        Long quantity = addProductToOrderRequest.getQuantity();

        //On vérifie qu'il y a suffisamment de stock, d'après la quantité donnée
        boolean res = orderManagerService.verifyStockOnProduct(product, quantity);

        if (!res) {
            return ResponseEntity.status(204).build();
        }

        //On ajoute le produit à la commande
        boolean res2 = orderManagerService.addProductToOrder(order, product, quantity);

        if (!res2) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).build();
    }

    @RequestMapping("/toOrder")
    public ResponseEntity<?> toOrder(@RequestBody ToOrderRequest toOrderRequest)
    {
        Order order = orderService.getById(toOrderRequest.getIdOrder());
        Long loyaltyPoints = toOrderRequest.getLoyaltyPoints();

        //À terme, les booléens seront remplacés par des Exception
        boolean res;

        //Si la commande n'a pas été payée ou est en attente de paiement
        if (order.getOrderStatus().getIdOrderStatus() == 0L || order.getOrderStatus().getIdOrderStatus() == 1L) {
            res = orderManagerService.toOrder(order, loyaltyPoints);
        }
        else {
            res = false;
        }

        if (res) {
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(204).build();
        }
    }
}