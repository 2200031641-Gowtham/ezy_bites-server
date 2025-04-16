package com.ezy_bites.server.ezy_bitesserver.controller;

import com.ezy_bites.server.ezy_bitesserver.enums.UserRole;
import com.ezy_bites.server.ezy_bitesserver.models.EzyUsers;
import com.ezy_bites.server.ezy_bitesserver.service.EzyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/users")
public class EzyUserController {

    @Autowired
    private EzyUserService userService;

    @GetMapping
    public ResponseEntity<List<EzyUsers>> getAllUsers() {
        List<EzyUsers> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody EzyUsers user) {
        String email = userService.postUser(user);
        return ResponseEntity.ok("User created with email: " + email);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody EzyUsers user) {
        String updatedEmail = userService.updateUser(id, user);
        return ResponseEntity.ok("Updated user with email: " + updatedEmail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        String result = userService.deleteUser(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/email")
    public ResponseEntity<EzyUsers> getUserByEmail(@RequestParam String email) {
        return userService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new com.ezy_bites.server.ezy_bitesserver.exceptions.ResourceNotFoundException("User not found with email: " + email));
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<EzyUsers>> getUsersByRole(@PathVariable UserRole role) {
        List<EzyUsers> users = userService.findByRole(role);
        return ResponseEntity.ok(users);
    }
}
