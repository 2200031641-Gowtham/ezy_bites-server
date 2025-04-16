package com.ezy_bites.server.ezy_bitesserver.controller;

import com.ezy_bites.server.ezy_bitesserver.enums.TableStatus;
import com.ezy_bites.server.ezy_bitesserver.models.RestaurantTables;
import com.ezy_bites.server.ezy_bitesserver.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tables")
public class RestaurantTablesController {

    @Autowired
    private RestaurantTableService tableService;

    @PostMapping
    public ResponseEntity<RestaurantTables> createTable(@RequestBody RestaurantTables table) {
        RestaurantTables created = tableService.createTable(table);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantTables> getTableById(@PathVariable Long id) {
        RestaurantTables table = tableService.findById(id);
        return ResponseEntity.ok(table);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<RestaurantTables>> getTablesByRestaurantAndStatus(
            @RequestParam Long restaurantId,
            @RequestParam TableStatus status
    ) {
        List<RestaurantTables> tables = tableService.findByRestaurantIdAndStatus(restaurantId, status);
        return ResponseEntity.ok(tables);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantTables> updateTable(@PathVariable Long id, @RequestBody RestaurantTables table) {
        RestaurantTables updated = tableService.updateTable(id, table);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTable(@PathVariable Long id) {
        tableService.deleteTable(id);
        return ResponseEntity.ok("Table deleted with id: " + id);
    }
}
