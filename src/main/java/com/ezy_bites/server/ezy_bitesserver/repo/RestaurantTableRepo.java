package com.ezy_bites.server.ezy_bitesserver.repo;

import com.ezy_bites.server.ezy_bitesserver.enums.TableStatus;
import com.ezy_bites.server.ezy_bitesserver.models.RestaurantTables;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantTableRepo extends JpaRepository<RestaurantTables, Long> {
    List<RestaurantTables> findByRestaurantIdAndStatus(Long restaurantId, TableStatus status);

}
