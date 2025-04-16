package com.ezy_bites.server.ezy_bitesserver.service;


import com.ezy_bites.server.ezy_bitesserver.models.MenuItem;

import java.util.List;

public interface MenuItemService {
    MenuItem createMenuItem(MenuItem menuItem);

    MenuItem findById(Long id);

    List<MenuItem> findByRestaurantIdAndAvailable(Long restaurantId);

    MenuItem updateMenuItem(Long id, MenuItem menuItem);

    void deleteMenuItem(Long id);
}