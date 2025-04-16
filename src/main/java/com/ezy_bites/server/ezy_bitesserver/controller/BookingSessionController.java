package com.ezy_bites.server.ezy_bitesserver.controller;

import com.ezy_bites.server.ezy_bitesserver.enums.BookingStatus;
import com.ezy_bites.server.ezy_bitesserver.models.BookingSession;
import com.ezy_bites.server.ezy_bitesserver.service.BookingSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking-sessions")
@CrossOrigin(origins = "*")
public class BookingSessionController {

    @Autowired
    private BookingSessionService bookingSessionService;

    @PostMapping
    public ResponseEntity<BookingSession> createBookingSession(@RequestBody BookingSession bookingSession) {
        BookingSession created = bookingSessionService.createBookingSession(bookingSession);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingSession> getBookingSessionById(@PathVariable Long id) {
        BookingSession found = bookingSessionService.findById(id);
        return ResponseEntity.ok(found);
    }

    @GetMapping("/restaurant/{restaurantId}/status/{status}")
    public ResponseEntity<List<BookingSession>> getByRestaurantIdAndStatus(
            @PathVariable Long restaurantId,
            @PathVariable BookingStatus status) {
        List<BookingSession> sessions = bookingSessionService.findByRestaurantIdAndStatus(restaurantId, status);
        return ResponseEntity.ok(sessions);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingSession>> getByUserId(@PathVariable Long userId) {
        List<BookingSession> sessions = bookingSessionService.findByUserId(userId);
        return ResponseEntity.ok(sessions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingSession> updateBookingSession(
            @PathVariable Long id,
            @RequestBody BookingSession bookingSession) {
        BookingSession updated = bookingSessionService.updateBookingSession(id, bookingSession);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookingSession(@PathVariable Long id) {
        bookingSessionService.deleteBookingSession(id);
        return ResponseEntity.ok("BookingSession deleted with id: " + id);
    }
}
