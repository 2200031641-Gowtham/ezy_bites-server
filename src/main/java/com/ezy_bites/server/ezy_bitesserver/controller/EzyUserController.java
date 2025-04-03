package com.ezy_bites.server.ezy_bitesserver.controller;

import com.ezy_bites.server.ezy_bitesserver.dto.EzyUserDTO;
import com.ezy_bites.server.ezy_bitesserver.models.EzyUsers;
import com.ezy_bites.server.ezy_bitesserver.service.EzyUserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class EzyUserController {

    @Autowired
    private EzyUserService userService;

    @GetMapping
    public ResponseEntity<List<EzyUsers>> getAllUsers() {
        try{
            return ResponseEntity.ok(userService.getAllUsers());
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody EzyUserDTO user) {
        try {
            return ResponseEntity.ok(userService.postUser(user));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@PathParam("id") Long id,@RequestBody EzyUserDTO user) {
        try {
            return ResponseEntity.ok(userService.updateUser(id,user));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@PathParam("id") Long id) {
        try{
            return ResponseEntity.ok(userService.deleteUser(id));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.noContent().build();
        }
    }

}
