package com.ezy_bites.server.ezy_bitesserver.service;
import com.ezy_bites.server.ezy_bitesserver.models.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant createRestaurant(Restaurant restaurant);

    Restaurant findById(Long id);

    List<Restaurant> findNearbyRestaurants(double latitude, double longitude, double distance);

    Restaurant updateRestaurant(Long id, Restaurant restaurant);

    void deleteRestaurant(Long id);
}
