package com.ezy_bites.server.ezy_bitesserver.service;

import com.ezy_bites.server.ezy_bitesserver.exceptions.ResourceNotFoundException;
import com.ezy_bites.server.ezy_bitesserver.models.Review;
import com.ezy_bites.server.ezy_bitesserver.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepo reviewRepository;

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + id));
    }

    @Override
    public List<Review> findByRestaurantId(Long restaurantId) {
        return reviewRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public Review updateReview(Long id, Review review) {
        Review existingReview = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + id));
        existingReview.setUser(review.getUser());
        existingReview.setRestaurant(review.getRestaurant());
        existingReview.setRating(review.getRating());
        existingReview.setComment(review.getComment());
        existingReview.setCreatedAt(review.getCreatedAt());
        return reviewRepository.save(existingReview);
    }

    @Override
    public void deleteReview(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new ResourceNotFoundException("Review not found with id: " + id);
        }
        reviewRepository.deleteById(id);
    }


}
