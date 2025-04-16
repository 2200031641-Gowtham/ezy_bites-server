package com.ezy_bites.server.ezy_bitesserver.repo;

import com.ezy_bites.server.ezy_bitesserver.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BillRepo extends JpaRepository<Bill, Long> {
    Optional<Bill> findByBookingSessionId(Long sessionId);
}
