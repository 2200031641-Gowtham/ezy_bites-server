package com.ezy_bites.server.ezy_bitesserver.service;

import com.ezy_bites.server.ezy_bitesserver.enums.BookingStatus;
import com.ezy_bites.server.ezy_bitesserver.exceptions.ResourceNotFoundException;
import com.ezy_bites.server.ezy_bitesserver.models.BookingSession;
import com.ezy_bites.server.ezy_bitesserver.repo.BookingSessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingSessionServiceImpl implements BookingSessionService {

    @Autowired
    private BookingSessionRepo bookingSessionRepository;

    @Override
    public BookingSession createBookingSession(BookingSession bookingSession) {
        return bookingSessionRepository.save(bookingSession);
    }

    @Override
    public BookingSession findById(Long id) {
        return bookingSessionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BookingSession not found with id: " + id));
    }

    @Override
    public List<BookingSession> findByRestaurantIdAndStatus(Long restaurantId, BookingStatus status) {
        return bookingSessionRepository.findByRestaurantIdAndStatus(restaurantId, status);
    }

    @Override
    public List<BookingSession> findByUserId(Long userId) {
        return bookingSessionRepository.findByUserId(userId);
    }

    @Override
    public BookingSession updateBookingSession(Long id, BookingSession bookingSession) {
        BookingSession existingBookingSession = bookingSessionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BookingSession not found with id: " + id));
        existingBookingSession.setUser(bookingSession.getUser());
        existingBookingSession.setRestaurant(bookingSession.getRestaurant());
        existingBookingSession.setEta(bookingSession.getEta());
        existingBookingSession.setNumberOfDiners(bookingSession.getNumberOfDiners());
        existingBookingSession.setFoodPreference(bookingSession.getFoodPreference());
        existingBookingSession.setNotes(bookingSession.getNotes());
        existingBookingSession.setStatus(bookingSession.getStatus());
        existingBookingSession.setTable(bookingSession.getTable());
        existingBookingSession.setCheckInTime(bookingSession.getCheckInTime());
        return bookingSessionRepository.save(existingBookingSession);
    }

    @Override
    public void deleteBookingSession(Long id) {
        if (!bookingSessionRepository.existsById(id)) {
            throw new ResourceNotFoundException("BookingSession not found with id: " + id);
        }
        bookingSessionRepository.deleteById(id);
        System.out.println("Deleted Restaurant Booking Session with id: " + id);
    }
}
