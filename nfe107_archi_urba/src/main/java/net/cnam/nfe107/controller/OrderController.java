package net.cnam.nfe107.controller;

import net.cnam.nfe107.controller.dto.OrderRequest;
import net.cnam.nfe107.controller.dto.OrderResponse;
import net.cnam.nfe107.domain.AddressService;
import net.cnam.nfe107.domain.CustomerService;
import net.cnam.nfe107.domain.OrderService;
import net.cnam.nfe107.domain.OrderStatusService;
import net.cnam.nfe107.domain.entity.*;
import net.cnam.nfe107.repository.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    CustomerService customerService;

    @Autowired
    AddressService addressService;

    @Autowired
    OrderStatusService orderStatusService;

    @GetMapping("/getAllOrders")
    @ResponseBody
    public ResponseEntity<ArrayList<OrderResponse>> getAllOrders() {

        List<OrderModel> orderFound = orderService.getAllOrders();
        ArrayList<OrderResponse> ordersResponse = new ArrayList<>();

        for (OrderModel orderModel:orderFound) {
            Customer customer = customerService.getById(orderModel.getCustomer().getIdCustomer());
            Address address = addressService.getById(orderModel.getAddress().getIdAddress());
            OrderStatus orderStatus = orderStatusService.getById(orderModel.getOrderStatus().getIdOrderStatus());
            OrderResponse order1 = new OrderResponse(new Order(orderModel), customer, address, orderStatus);

            ordersResponse.add(order1);
        }

        return new ResponseEntity<>(ordersResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<OrderResponse> getOrder(@PathVariable("id") Long id) {
        Order orderFound = orderService.getById(id);
        Customer customerFound = customerService.getById(orderFound.getCustomer().getIdCustomer());
        Address addressFound = addressService.getById(orderFound.getAddress().getIdAddress());
        OrderStatus orderStatusFound = orderStatusService.getById(orderFound.getOrderStatus().getIdOrderStatus());

        OrderResponse orderResponse = new OrderResponse(orderFound, customerFound, addressFound, orderStatusFound);

        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        OrderToCreate orderToCreate = new OrderToCreate(orderRequest);

        Customer customerFound = customerService.getById(orderRequest.getIdCustomer());
        Address addressFound = addressService.getById(orderRequest.getIdAddress());
        OrderStatus orderStatusFound = orderStatusService.getById(orderRequest.getIdOrderStatus());
        Order orderCreated = orderService.create(orderToCreate, customerFound, addressFound, orderStatusFound);

        OrderResponse orderResponse = new OrderResponse(orderCreated);

        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<OrderResponse> updateOrder(@RequestBody OrderRequest orderRequest)
    {
        Customer customerFound = customerService.getById(orderRequest.getIdCustomer());
        Address addressFound = addressService.getById(orderRequest.getIdAddress());
        OrderStatus orderStatusFound = orderStatusService.getById(orderRequest.getIdOrderStatus());
        Order orderToUpdate = new Order(orderRequest, customerFound, addressFound, orderStatusFound);

        Order orderUpdated = orderService.update(orderToUpdate);

        OrderResponse orderResponse = new OrderResponse(orderUpdated);

        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<OrderResponse> deleteOrder(@PathVariable("id") Long id)
    {
        orderService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
