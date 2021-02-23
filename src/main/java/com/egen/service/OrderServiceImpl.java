package com.egen.service;

import com.egen.model.Order;
import com.egen.repository.OrderRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    @Transactional
    public Order createOrder(Order order) {
        order.setOrder_status(Order.Status.CREATED);
        orderRepository.save(order);
        return order;
    }

    @Override
    @Transactional
    public Order cancelOrder(long orderId) throws NotFoundException {

        Optional<Order> order = orderRepository.findById(orderId);
        order.ifPresent(o -> o.setOrder_status(Order.Status.CANCELLED));
        order.orElseThrow(() -> new NotFoundException("No orderId found by id " + orderId));
        orderRepository.save(order.get());
        return order.get();
    }
}
