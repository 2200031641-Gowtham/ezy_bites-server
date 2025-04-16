package com.ezy_bites.server.ezy_bitesserver.service;


import com.ezy_bites.server.ezy_bitesserver.enums.OrderStatus;
import com.ezy_bites.server.ezy_bitesserver.models.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    Order findById(Long id);

    List<Order> findByBookingSessionIdAndStatus(Long sessionId, OrderStatus status);

    Order updateOrder(Long id, Order order);

    void deleteOrder(Long id);
}
