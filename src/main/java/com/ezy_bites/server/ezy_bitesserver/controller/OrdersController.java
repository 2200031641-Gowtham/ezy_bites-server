package com.ezy_bites.server.ezy_bitesserver.controller;

import com.ezy_bites.server.ezy_bitesserver.enums.OrderStatus;
import com.ezy_bites.server.ezy_bitesserver.models.Order;
import com.ezy_bites.server.ezy_bitesserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order created = orderService.createOrder(order);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order found = orderService.findById(id);
        return ResponseEntity.ok(found);
    }

    @GetMapping("/booking-session/{sessionId}")
    public ResponseEntity<List<Order>> getOrdersBySessionAndStatus(
            @PathVariable Long sessionId,
            @RequestParam OrderStatus status
    ) {
        List<Order> orders = orderService.findByBookingSessionIdAndStatus(sessionId, status);
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        Order updated = orderService.updateOrder(id, order);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Order deleted with id: " + id);
    }
}
