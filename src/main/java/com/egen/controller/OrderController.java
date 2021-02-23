package com.egen.controller;


import com.egen.model.Order;
import com.egen.service.OrderService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OrderController {
    
    private OrderService orderService;

    @Autowired
    public void serOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getOrder(@PathVariable long orderId) {

        try {
            Order order = orderService.findOne(orderId);
            return new ResponseEntity<>(order, HttpStatus.OK);

        } catch (NotFoundException e) {
            return new ResponseEntity<>("No order found with id" + orderId, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/order/")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return new ResponseEntity<>("Order placed successfully", HttpStatus.CREATED);
    }

    @PutMapping("/order/{orderId}")
    public ResponseEntity<?> cancelOrder(@PathVariable long orderId) {
        try {
            orderService.cancelOrder(orderId);
        } catch (NotFoundException e) {
            return new ResponseEntity<>("No order found with id" + orderId, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Order cancelled successfully", HttpStatus.OK);
    }
}
