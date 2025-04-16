package com.ezy_bites.server.ezy_bitesserver.service;


import com.ezy_bites.server.ezy_bitesserver.enums.BookingStatus;
import com.ezy_bites.server.ezy_bitesserver.models.BookingSession;

import java.util.List;

public interface BookingSessionService {
    BookingSession createBookingSession(BookingSession bookingSession);

    BookingSession findById(Long id);

    List<BookingSession> findByRestaurantIdAndStatus(Long restaurantId, BookingStatus status);

    List<BookingSession> findByUserId(Long userId);

    BookingSession updateBookingSession(Long id, BookingSession bookingSession);

    void deleteBookingSession(Long id);
}
