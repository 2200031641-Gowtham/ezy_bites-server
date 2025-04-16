package com.ezy_bites.server.ezy_bitesserver.service;

import com.ezy_bites.server.ezy_bitesserver.enums.TableStatus;
import com.ezy_bites.server.ezy_bitesserver.exceptions.ResourceNotFoundException;
import com.ezy_bites.server.ezy_bitesserver.models.RestaurantTables;
import com.ezy_bites.server.ezy_bitesserver.repo.RestaurantTableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantTableServiceImpl implements RestaurantTableService {

    @Autowired
    private RestaurantTableRepo tableRepository;


    @Override
    public RestaurantTables createTable(RestaurantTables table) {
        return tableRepository.save(table);
    }

    @Override
    public RestaurantTables findById(Long id) {
        return tableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Table not found with id: " + id));
    }

    @Override
    public List<RestaurantTables> findByRestaurantIdAndStatus(Long restaurantId, TableStatus status) {
        return tableRepository.findByRestaurantIdAndStatus(restaurantId, status);
    }

    @Override
    public RestaurantTables updateTable(Long id, RestaurantTables table) {
        RestaurantTables existingTable = tableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Table not found with id: " + id));
        existingTable.setRestaurant(table.getRestaurant());
        existingTable.setTableNumber(table.getTableNumber());
        existingTable.setCapacity(table.getCapacity());
        existingTable.setStatus(table.getStatus());
        return tableRepository.save(existingTable);
    }

    @Override
    public void deleteTable(Long id) {
        if (!tableRepository.existsById(id)) {
            throw new ResourceNotFoundException("Table not found with id: " + id);
        }
        tableRepository.deleteById(id);
        System.out.println("Deleted Restaurant Table with id: " + id);
    }
}
