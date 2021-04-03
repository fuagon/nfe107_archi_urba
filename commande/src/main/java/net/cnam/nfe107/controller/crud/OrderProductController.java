package net.cnam.nfe107.controller.crud;

import net.cnam.nfe107.controller.dto.*;
import net.cnam.nfe107.domain.entity.crud.OrderProductService;
import net.cnam.nfe107.domain.entity.crud.OrderService;
import net.cnam.nfe107.domain.entity.crud.ProductService;
import net.cnam.nfe107.domain.entity.*;
import net.cnam.nfe107.repository.model.OrderModel;
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
    public ResponseEntity<ArrayList<OrderProductResponseSmartList>> getAllOrderProduct()
    {
        List<OrderModel> orders = orderService.getAllOrders();
        ArrayList<OrderProductResponseSmartList> products = new ArrayList<>();

        for (OrderModel orderModel:orders)
        {
            ArrayList<OrderProductResponseWithoutIdOrder> listOfOrderProductResponseWithoutIdOrder = new ArrayList<>();

            var ordersProducts = orderModel.getOrdersProducts();
            OrderProductResponseSmartList orderProductResponseSmartList2 = new OrderProductResponseSmartList();

            for (OrderProductModel orderProductModel:ordersProducts)
            {
                listOfOrderProductResponseWithoutIdOrder.add(new OrderProductResponseWithoutIdOrder(new Order(orderProductModel.getOrder()), new Product(orderProductModel.getProduct()), orderProductModel.getQuantity()));
            }

            orderProductResponseSmartList2.setIdOrder(orderModel.getIdOrder());
            orderProductResponseSmartList2.setList(listOfOrderProductResponseWithoutIdOrder);
            products.add(orderProductResponseSmartList2);
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
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
