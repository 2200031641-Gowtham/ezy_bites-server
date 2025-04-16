package com.ezy_bites.server.ezy_bitesserver.repo;

import com.ezy_bites.server.ezy_bitesserver.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long> {
    List<Review> findByRestaurantId(Long restaurantId);
}