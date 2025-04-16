package com.ezy_bites.server.ezy_bitesserver.repo;

import com.ezy_bites.server.ezy_bitesserver.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {
    @Query("SELECT r FROM Restaurant r WHERE " +
            "6371 * acos(cos(radians(:latitude)) * cos(radians(r.latitude)) * " +
            "cos(radians(r.longitude) - radians(:longitude)) + " +
            "sin(radians(:latitude)) * sin(radians(r.latitude))) < :distance")
    List<Restaurant> findNearbyRestaurants(double latitude, double longitude, double distance);
}