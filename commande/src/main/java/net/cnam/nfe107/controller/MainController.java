package net.cnam.nfe107.controller;

import net.cnam.nfe107.controller.dto.*;
import net.cnam.nfe107.domain.OrderProductServiceUnit;
import net.cnam.nfe107.domain.OrderServiceUnit;
import net.cnam.nfe107.domain.ProductServiceUnit;
import net.cnam.nfe107.domain.entity.*;
import net.cnam.nfe107.domain.entity.crud.OrderProductService;
import net.cnam.nfe107.domain.entity.crud.OrderService;
import net.cnam.nfe107.domain.entity.crud.OrderStatusService;
import net.cnam.nfe107.domain.entity.crud.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/commande")
public class MainController {

    @Autowired
    ProductServiceUnit productServiceUnit;

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderStatusService orderStatusService;

    @Autowired
    OrderProductService orderProductService;

    @Autowired
    OrderServiceUnit orderServiceUnit;
    @Autowired
    OrderProductServiceUnit orderProductServiceUnit;


    @PostMapping("/creer")
    @ResponseBody
    public ResponseEntity<OrderCompleteResponse> creer(@RequestBody CreateCommandeRequest commandeRequest) {

        // On initialize l'etat de la commande comme 'En cours de création'
        var status = orderStatusService.getById(Long.valueOf(0));

        // Creation de la commande
        var order = orderService.create(new OrderToCreate(commandeRequest.getDate(), commandeRequest.getIdCustomer(), commandeRequest.getIdAddress(), status));

        // Identification du produit
        var product = productService.getById(commandeRequest.getIdProduct());

        // Ajout du produit identifié dans la commande
        orderProductService.create(order, product , commandeRequest.getQuantite());

        // Actualisation de l'objet order
        order = orderService.getById(order.getIdOrder());

        OrderCompleteResponse orderCompleteResponse = new OrderCompleteResponse(order);
        return new ResponseEntity<>(orderCompleteResponse, HttpStatus.CREATED);

    }

    @PostMapping("/ajouterProduitCommande")
    @ResponseBody
    public ResponseEntity<OrderCompleteResponse> ajouterProduitCommande(@RequestBody AddProductCommandRequest addProductCommandRequest) {
        var existC = true;
        var existP = false;
        Order order;
        OrderProduct opm;
        try{
            order = orderService.getById(addProductCommandRequest.getIdOrder());
        }catch (EntityNotFoundException exception){
            order = null;
        }

        if(order != null){


            var list = order.getOrderProducts();

            for ( var op: list) {
                if(op.getProduct().getIdProduct() == addProductCommandRequest.getIdProduct()){
                    existP = true;
                }
            }
            if (existP){
                orderProductServiceUnit.increaseQuantity(addProductCommandRequest.getIdOrder(), addProductCommandRequest.getIdProduct(), addProductCommandRequest.getQuantity());
            }

            return new ResponseEntity<>(new OrderCompleteResponse(orderService.getById(order.getIdOrder())), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);

    }


    @PostMapping("/supprimerProduitCommande")
    @ResponseBody
    public ResponseEntity<OrderCompleteResponse> supprimerProduitCommande(@RequestBody AddProductCommandRequest addProductCommandRequest) {
        var existC = true;
        var existP = false;
        Order order;
        OrderProduct opm;
        try{
            order = orderService.getById(addProductCommandRequest.getIdOrder());
        }catch (EntityNotFoundException exception){
            order = null;
        }

        if(order != null){

            var list = order.getOrderProducts();

            if(list != null) {
                for (var op : list) {
                    if (op.getProduct().getIdProduct() == addProductCommandRequest.getIdProduct()) {
                        existP = true;
                    }
                }
                if (existP) {
                    orderProductServiceUnit.decreaseQuantity(addProductCommandRequest.getIdOrder(), addProductCommandRequest.getIdProduct(), addProductCommandRequest.getQuantity());
                } else {
                    return new ResponseEntity<>(HttpStatus.CONFLICT);
                }

                return new ResponseEntity<>(new OrderCompleteResponse(orderService.getById(order.getIdOrder())), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);


    }

    @PostMapping("/validerCommande")
    @ResponseBody
    public ResponseEntity<OrderValidateResponse> validerCommande(@RequestBody ValidateCommandeRequest validateCommandeRequest) {

        var order = orderServiceUnit.validateCommande(validateCommandeRequest.getIdOrder());
        if(order != null){
            return new ResponseEntity<>(new OrderValidateResponse(order, validateCommandeRequest.getFidelityPointUsed()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

}
