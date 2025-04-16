package com.ezy_bites.server.ezy_bitesserver.service;

import com.ezy_bites.server.ezy_bitesserver.exceptions.ResourceNotFoundException;
import com.ezy_bites.server.ezy_bitesserver.models.Restaurant;
import com.ezy_bites.server.ezy_bitesserver.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    private RestaurantRepo restaurantRepository;

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant findById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + id));    }

    @Override
    public List<Restaurant> findNearbyRestaurants(double latitude, double longitude, double distance) {
        return restaurantRepository.findNearbyRestaurants(latitude, longitude, distance);
    }

    @Override
    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
        Restaurant existingRestaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + id));
        existingRestaurant.setName(restaurant.getName());
        existingRestaurant.setLatitude(restaurant.getLatitude());
        existingRestaurant.setLongitude(restaurant.getLongitude());
        existingRestaurant.setDescription(restaurant.getDescription());
        existingRestaurant.setOpenTime(restaurant.getOpenTime());
        existingRestaurant.setCloseTime(restaurant.getCloseTime());
        existingRestaurant.setCategory(restaurant.getCategory());
        existingRestaurant.setImageUrl(restaurant.getImageUrl());
        return restaurantRepository.save(existingRestaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {
        if (!restaurantRepository.existsById(id)) {
            throw new ResourceNotFoundException("Restaurant not found with id: " + id);
        }
        restaurantRepository.deleteById(id);
        System.out.println("Deleted Restaurant with id: " + id);
    }
}
