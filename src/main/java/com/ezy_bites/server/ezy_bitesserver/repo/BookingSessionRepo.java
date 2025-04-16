package com.ezy_bites.server.ezy_bitesserver.repo;

import com.ezy_bites.server.ezy_bitesserver.enums.BookingStatus;
import com.ezy_bites.server.ezy_bitesserver.models.BookingSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingSessionRepo extends JpaRepository<BookingSession, Long> {
    List<BookingSession> findByRestaurantIdAndStatus(Long restaurantId, BookingStatus status);

    List<BookingSession> findByUserId(Long userId);
}
