package net.cnam.nfe107.controller;

import net.cnam.nfe107.controller.dto.*;
import net.cnam.nfe107.domain.*;
import net.cnam.nfe107.domain.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceController {

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderProductService orderProductService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderStatusService orderStatusService;

    //Pour augmenter la quantité d'un produit dans une commande
    @PutMapping("/increaseQuantity")
    @ResponseBody
    public ResponseEntity<OrderProductResponse> increaseQuantity(@RequestBody OrderProductRequest orderProductRequest) {
        OrderProduct orderProduct = orderProductService.getById(orderProductRequest.getIdOrder(), orderProductRequest.getIdProduct());
        orderProduct.setQuantity(orderProduct.getQuantity() + orderProductRequest.getQuantity());

        orderProduct = orderProductService.update(orderProduct);

        OrderProductResponse orderProductResponse = new OrderProductResponse(orderProduct);

        return new ResponseEntity<>(orderProductResponse, HttpStatus.OK);
    }

    //Pour diminuer la quantité d'un produit dans une commande
    @PutMapping("/decreaseQuantity")
    @ResponseBody
    public ResponseEntity<OrderProductResponse> decreaseQuantity(@RequestBody OrderProductRequest orderProductRequest) {
        OrderProduct orderProduct = orderProductService.getById(orderProductRequest.getIdOrder(), orderProductRequest.getIdProduct());
        orderProduct.setQuantity(orderProduct.getQuantity() - orderProductRequest.getQuantity());

        orderProduct = orderProductService.update(orderProduct);

        OrderProductResponse orderProductResponse = new OrderProductResponse(orderProduct);

        return new ResponseEntity<>(orderProductResponse, HttpStatus.OK);
    }

    //Ajouter des points de fidélité à un utilisateur
    @PutMapping("/addLoyaltyPoints")
    @ResponseBody
    public ResponseEntity<CustomerResponse> addLoyaltyPoints(@RequestBody LoyaltyPointsRequest loyaltyPointsRequest) {
        Customer customer = customerService.getById(loyaltyPointsRequest.getIdCustomer());
        customer.setLoyaltyPoints(customer.getLoyaltyPoints() + loyaltyPointsRequest.getLoyaltyPoints());

        customer = customerService.update(customer);

        CustomerResponse customerResponse = new CustomerResponse(customer);

        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    //Retirer des points de fidélité à un utilisateur
    @PutMapping("/removeLoyaltyPoints")
    @ResponseBody
    public ResponseEntity<CustomerResponse> removeLoyaltyPoints(@RequestBody LoyaltyPointsRequest loyaltyPointsRequest) {
        Customer customer = customerService.getById(loyaltyPointsRequest.getIdCustomer());
        customer.setLoyaltyPoints(customer.getLoyaltyPoints() - loyaltyPointsRequest.getLoyaltyPoints());

        customer = customerService.update(customer);

        CustomerResponse customerResponse = new CustomerResponse(customer);

        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    //Ajouter du stock sur un produit
    @PutMapping("/addStock")
    @ResponseBody
    public ResponseEntity<ProductResponse> addStock(@RequestBody ProductRequest productRequest) {
        Product product = productService.getById(productRequest.getIdProduct());
        product.setStock(product.getStock() + productRequest.getStock());

        product = productService.update(product);

        ProductResponse productResponse = new ProductResponse(product);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    //Retirer du stock sur un produit
    @PutMapping("/removeStock")
    @ResponseBody
    public ResponseEntity<ProductResponse> removeStock(@RequestBody ProductRequest productRequest) {
        Product product = productService.getById(productRequest.getIdProduct());
        product.setStock(product.getStock() - productRequest.getStock());

        product = productService.update(product);

        ProductResponse productResponse = new ProductResponse(product);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    //Mettre à jour le statut d'une commande
    @PutMapping("/updateStatusOfOrder")
    @ResponseBody
    public ResponseEntity<OrderResponse> updateOrderStatus(@RequestBody OrderRequest orderRequest) {
        Order order = orderService.getById(orderRequest.getIdOrder());
        OrderStatus orderStatus = orderStatusService.getById(orderRequest.getIdOrderStatus());
        order.setOrderStatus(orderStatus);

        order = orderService.update(order);

        OrderResponse orderResponse = new OrderResponse(order);

        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }
}