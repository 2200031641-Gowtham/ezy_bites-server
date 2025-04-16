package com.ezy_bites.server.ezy_bitesserver.repo;

import com.ezy_bites.server.ezy_bitesserver.enums.OrderStatus;
import com.ezy_bites.server.ezy_bitesserver.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findByBookingSessionIdAndStatus(Long sessionId, OrderStatus status);
}