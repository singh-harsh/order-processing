package com.egen.service;

import com.egen.model.Order;
import javassist.NotFoundException;

public interface OrderService {

    public Order findOne(long orderId) throws NotFoundException;

    public Order createOrder(Order order);

    public Order cancelOrder(long orderId) throws NotFoundException;
}
