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

        List<Order> orders = orderService.getAllOrders();
        ArrayList<OrderResponse> ordersResponse = new ArrayList<>();

        for (Order order:orders) {
            ordersResponse.add(new OrderResponse(order, order.getCustomer(), order.getAddress(), order.getOrderStatus()));
        }

        return new ResponseEntity<>(ordersResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<OrderResponse> getOrder(@PathVariable("id") Long id) {
        Order order = orderService.getById(id);

        OrderResponse orderResponse = new OrderResponse(order, order.getCustomer(), order.getAddress(), order.getOrderStatus());

        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        OrderToCreate orderToCreate = new OrderToCreate(orderRequest);

        orderToCreate.setCustomer(customerService.getById(orderRequest.getIdCustomer()));
        orderToCreate.setAddress(addressService.getById(orderRequest.getIdAddress()));
        orderToCreate.setOrderStatus(orderStatusService.getById(orderRequest.getIdOrderStatus()));
        Order orderCreated = orderService.create(orderToCreate);

        OrderResponse orderResponse = new OrderResponse(orderCreated);

        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<OrderResponse> updateOrder(@RequestBody OrderRequest orderRequest)
    {
        Customer customer = customerService.getById(orderRequest.getIdCustomer());
        Address address = addressService.getById(orderRequest.getIdAddress());
        OrderStatus orderStatus = orderStatusService.getById(orderRequest.getIdOrderStatus());
        Order orderToUpdate = new Order(orderRequest, customer, address, orderStatus);

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
