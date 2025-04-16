package com.ezy_bites.server.ezy_bitesserver.service;


import com.ezy_bites.server.ezy_bitesserver.models.Bill;

import java.util.Optional;

public interface BillService {
    Bill createBill(Bill bill);

    Optional<Bill> findByBookingSessionId(Long sessionId);

    Bill updateBill(Long id, Bill bill);

    void deleteBill(Long id);
}

