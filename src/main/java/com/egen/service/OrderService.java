package com.egen.service;

import com.egen.model.Order;
import javassist.NotFoundException;

public interface OrderService {

    Order findOne(long orderId);

    Order createOrder(Order order);

    Order cancelOrder(long orderId);
}
