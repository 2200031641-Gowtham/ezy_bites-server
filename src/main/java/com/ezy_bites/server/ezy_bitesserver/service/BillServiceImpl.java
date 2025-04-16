package com.ezy_bites.server.ezy_bitesserver.service;

import com.ezy_bites.server.ezy_bitesserver.exceptions.ResourceNotFoundException;
import com.ezy_bites.server.ezy_bitesserver.models.Bill;
import com.ezy_bites.server.ezy_bitesserver.repo.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepo billRepository;

    @Override
    public Bill createBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Optional<Bill> findByBookingSessionId(Long sessionId) {
        return billRepository.findByBookingSessionId(sessionId);
    }

    @Override
    public Bill updateBill(Long id, Bill bill) {
        Bill existingBill = billRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bill not found with id: " + id));
        existingBill.setBookingSession(bill.getBookingSession());
        existingBill.setTotalAmount(bill.getTotalAmount());
        existingBill.setIsVerified(bill.getIsVerified());
        existingBill.setIsPaid(bill.getIsPaid());
        return billRepository.save(existingBill);
    }

    @Override
    public void deleteBill(Long id) {
        if (!billRepository.existsById(id)) {
            throw new ResourceNotFoundException("Bill not found with id: " + id);
        }
        billRepository.deleteById(id);
        System.out.println("Deleted Bill with id: " + id);
    }
}
