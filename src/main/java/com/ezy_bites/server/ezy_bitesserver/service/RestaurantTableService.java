package com.ezy_bites.server.ezy_bitesserver.service;

import com.ezy_bites.server.ezy_bitesserver.enums.TableStatus;
import com.ezy_bites.server.ezy_bitesserver.models.RestaurantTables;

import java.util.List;

public interface RestaurantTableService {

    RestaurantTables createTable(RestaurantTables table);

    RestaurantTables findById(Long id);

    List<RestaurantTables> findByRestaurantIdAndStatus(Long restaurantId, TableStatus status);

    RestaurantTables updateTable(Long id, RestaurantTables table);

    void deleteTable(Long id);

}
