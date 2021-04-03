package net.cnam.nfe107.controller.crud;

import net.cnam.nfe107.controller.dto.crud.OrderRequest;
import net.cnam.nfe107.controller.dto.crud.OrderResponse;
import net.cnam.nfe107.domain.entity.crud.OrderService;
import net.cnam.nfe107.domain.entity.crud.OrderStatusService;
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
    OrderStatusService orderStatusService;

    @GetMapping("/getAllOrders")
    @ResponseBody
    public ResponseEntity<ArrayList<OrderResponse>> getAllOrders() {

        List<OrderModel> orderFound = orderService.getAllOrders();
        ArrayList<OrderResponse> ordersResponse = new ArrayList<>();

        for (OrderModel orderModel:orderFound) {
            OrderStatus orderStatus = orderStatusService.getById(orderModel.getOrderStatus().getIdOrderStatus());
            OrderResponse order1 = new OrderResponse(new Order(orderModel), orderStatus);

            ordersResponse.add(order1);
        }

        return new ResponseEntity<>(ordersResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<OrderResponse> getOrder(@PathVariable("id") Long id) {
        Order orderFound = orderService.getById(id);
        OrderStatus orderStatusFound = orderStatusService.getById(orderFound.getOrderStatus().getIdOrderStatus());

        OrderResponse orderResponse = new OrderResponse(orderFound, orderStatusFound);

        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        OrderToCreate orderToCreate = new OrderToCreate(orderRequest);

        orderToCreate.setOrderStatus(orderStatusService.getById(orderRequest.getIdOrderStatus()));
        Order orderCreated = orderService.create(orderToCreate);

        OrderResponse orderResponse = new OrderResponse(orderCreated);

        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<OrderResponse> updateOrder(@RequestBody OrderRequest orderRequest)
    {


        OrderStatus orderStatusFound = orderStatusService.getById(orderRequest.getIdOrderStatus());
        Order orderToUpdate = new Order(orderRequest, orderStatusFound);

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
