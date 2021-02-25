package com.egen.controller;

import com.egen.model.Order;
import com.egen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public void serOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable long orderId) {
        return orderService.findOne(orderId);
    }

    @PostMapping("/")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        System.out.println("HERE");
//        orderService.createOrder(order);
        return new ResponseEntity<>("Order placed successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}")
    public Order cancelOrder(@PathVariable long orderId) {
        return orderService.cancelOrder(orderId);
    }
}
