package net.cnam.nfe107.controller.crud;

import net.cnam.nfe107.controller.dto.crud.OrderStatusRequest;
import net.cnam.nfe107.controller.dto.crud.OrderStatusResponse;
import net.cnam.nfe107.domain.entity.crud.OrderStatusService;
import net.cnam.nfe107.domain.entity.*;
import net.cnam.nfe107.repository.model.OrderStatusModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orderStatus")
public class OrderStatusController {

    @Autowired
    OrderStatusService orderStatusService;

    @GetMapping("/getAllOrderStatus")
    @ResponseBody
    public ResponseEntity<ArrayList<OrderStatusResponse>> getAllOrderStatus() {

        List<OrderStatusModel> orderStatusFound = orderStatusService.getAllOrderStatus();
        ArrayList<OrderStatusResponse> ordersResponse = new ArrayList<>();

        for (OrderStatusModel orderStatusModel:orderStatusFound) {
            OrderStatusResponse orderStatusResponse = new OrderStatusResponse(orderStatusModel);

            ordersResponse.add(orderStatusResponse);
        }

        return new ResponseEntity<>(ordersResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<OrderStatusResponse> getOrder(@PathVariable("id") Long id) {
        OrderStatus orderStatusFound = orderStatusService.getById(id);

        OrderStatusResponse orderStatusResponse = new OrderStatusResponse(orderStatusFound);

        return new ResponseEntity<>(orderStatusResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<OrderStatusResponse> createOrder(@RequestBody OrderStatusRequest orderStatusRequest) {
        OrderStatusToCreate orderStatusToCreate = new OrderStatusToCreate(orderStatusRequest);

        OrderStatus orderStatusCreated = orderStatusService.create(orderStatusToCreate);

        OrderStatusResponse orderStatusResponse = new OrderStatusResponse(orderStatusCreated);

        return new ResponseEntity<>(orderStatusResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<OrderStatusResponse> updateOrder(@RequestBody OrderStatusRequest orderStatusRequest)
    {
        OrderStatus orderStatusToUpdate = new OrderStatus(orderStatusRequest);

        OrderStatus orderStatusUpdated = orderStatusService.update(orderStatusToUpdate);

        OrderStatusResponse orderStatusResponse = new OrderStatusResponse(orderStatusUpdated);

        return new ResponseEntity<>(orderStatusResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<OrderStatusResponse> deleteOrder(@PathVariable("id") Long id)
    {
        orderStatusService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
