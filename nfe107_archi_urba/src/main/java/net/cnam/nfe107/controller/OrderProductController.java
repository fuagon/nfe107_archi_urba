package net.cnam.nfe107.controller;

import net.cnam.nfe107.controller.dto.OrderProductRequest;
import net.cnam.nfe107.controller.dto.OrderProductResponse;
import net.cnam.nfe107.controller.dto.OrderRequest;
import net.cnam.nfe107.controller.dto.OrderResponse;
import net.cnam.nfe107.domain.OrderProductService;
import net.cnam.nfe107.domain.OrderService;
import net.cnam.nfe107.domain.ProductService;
import net.cnam.nfe107.domain.entity.*;
import net.cnam.nfe107.repository.model.OrderModel;
import net.cnam.nfe107.repository.model.OrderProductIdModel;
import net.cnam.nfe107.repository.model.OrderProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orderProduct")
public class OrderProductController {

    @Autowired
    OrderProductService orderProductService;

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @GetMapping("/getAllOrderProduct")
    @ResponseBody
    public ResponseEntity<ArrayList<OrderProductResponse>> getAllOrderProduct() {

        List<OrderProductModel> orderProductFound = orderProductService.getAllOrderProduct();
        ArrayList<OrderProductResponse> orderProductResponse = new ArrayList<>();

        for (OrderProductModel orderProductModel:orderProductFound) {
            Order order = new Order(orderProductModel.getOrder());
            Product product = new Product(orderProductModel.getProduct());
            OrderProductResponse orderProduct1 = new OrderProductResponse(order, product, orderProductModel.getQuantity());

            orderProductResponse.add(orderProduct1);
        }

        return new ResponseEntity<>(orderProductResponse, HttpStatus.OK);
    }

    @GetMapping("/order/{idOrder}/product/{idProduct}")
    @ResponseBody
    public ResponseEntity<OrderProductResponse> getOrderProduct(@PathVariable("idOrder") Long idOrder, @PathVariable("idProduct") Long idProduct) {

        OrderProduct orderProduct = orderProductService.getById(idOrder, idProduct);
        OrderProductResponse orderProductResponse = new OrderProductResponse(orderProduct);

        return new ResponseEntity<>(orderProductResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<OrderProductResponse> createOrderProduct(@RequestBody OrderProductRequest orderProductRequest) {
        OrderProductToCreate orderProductToCreate = new OrderProductToCreate(orderProductRequest);

        Order order = orderService.getById(orderProductRequest.getIdOrder());
        Product product = productService.getById(orderProductRequest.getIdProduct());
        OrderProduct orderProductCreated = orderProductService.create(order, product, orderProductRequest.getQuantity());
        OrderProductResponse orderProductResponse = new OrderProductResponse(orderProductCreated);

        return new ResponseEntity<>(orderProductResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<OrderProductResponse> updateOrderProduct(@RequestBody OrderProductRequest orderProductRequest)
    {
        Order order = orderService.getById(orderProductRequest.getIdOrder());
        Product product = productService.getById(orderProductRequest.getIdProduct());
        OrderProduct orderProductToUpdate = new OrderProduct(order, product, orderProductRequest.getQuantity());

        OrderProduct orderProductUpdated = orderProductService.update(orderProductToUpdate);

        OrderProductResponse orderProductResponse = new OrderProductResponse(orderProductUpdated);

        return new ResponseEntity<>(orderProductResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/order/{idOrder}/product/{idProduct}")
    @ResponseBody
    public ResponseEntity<OrderProductResponse> deleteOrderProduct(@PathVariable("idOrder") Long idOrder, @PathVariable("idProduct") Long idProduct)
    {
        orderProductService.delete(idOrder, idProduct);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
