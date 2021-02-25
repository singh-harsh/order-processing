package com.egen.service;

import com.egen.exception.ResourceNotFoundException;
import com.egen.model.Order;
import com.egen.repository.OrderRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public Order findOne(long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id :" + orderId));
    }

    @Override
    @Transactional
    public Order createOrder(Order order) {
        order.setOrder_status(Order.Status.CREATED);
        order.setOrderCreateDate(new Date());
        orderRepository.save(order);
        return order;
    }

    @Override
    @Transactional
    public Order cancelOrder(long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        order.ifPresent(o -> {
                    o.setOrder_status(Order.Status.CANCELLED);
                    o.setOrderModifyDate(new Date());
                }
        );
        order.orElseThrow(() -> new ResourceNotFoundException("No orderId found by id " + orderId));
        orderRepository.save(order.get());
        return order.get();
    }
}
