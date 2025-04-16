package com.ezy_bites.server.ezy_bitesserver.controller;

import com.ezy_bites.server.ezy_bitesserver.exceptions.ResourceNotFoundException;
import com.ezy_bites.server.ezy_bitesserver.models.Bill;
import com.ezy_bites.server.ezy_bitesserver.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bills")
@CrossOrigin(origins = "*")
public class BillsController {

    @Autowired
    private BillService billService;

    @PostMapping
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
        Bill created = billService.createBill(bill);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/booking-session/{sessionId}")
    public ResponseEntity<Bill> getBillByBookingSessionId(@PathVariable Long sessionId) {
        return billService.findByBookingSessionId(sessionId)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Bill not found for session id: " + sessionId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable Long id, @RequestBody Bill bill) {
        Bill updated = billService.updateBill(id, bill);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable Long id) {
        billService.deleteBill(id);
        return ResponseEntity.ok("Bill deleted with id: " + id);
    }
}
