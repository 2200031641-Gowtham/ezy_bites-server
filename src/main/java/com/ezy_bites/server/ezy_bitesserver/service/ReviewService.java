package com.ezy_bites.server.ezy_bitesserver.service;


import com.ezy_bites.server.ezy_bitesserver.models.Review;

import java.util.List;

public interface ReviewService {
    Review createReview(Review review);

    Review findById(Long id);

    List<Review> findByRestaurantId(Long restaurantId);

    Review updateReview(Long id, Review review);

    void deleteReview(Long id);
}
