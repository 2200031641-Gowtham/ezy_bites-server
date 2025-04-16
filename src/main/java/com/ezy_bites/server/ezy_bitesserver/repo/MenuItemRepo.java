package com.ezy_bites.server.ezy_bitesserver.repo;

import com.ezy_bites.server.ezy_bitesserver.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {

    List<MenuItem> findByRestaurantIdAndIsAvailableTrue(Long restaurantId);


}
