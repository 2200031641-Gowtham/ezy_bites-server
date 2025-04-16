package com.ezy_bites.server.ezy_bitesserver.controller;

import com.ezy_bites.server.ezy_bitesserver.models.EzySuperAdmins;
import com.ezy_bites.server.ezy_bitesserver.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/superadmins")
public class SuperAdminController {

    @Autowired
    private SuperAdminService superAdminService;

    @PostMapping
    public ResponseEntity<EzySuperAdmins> createSuperAdmin(@RequestBody EzySuperAdmins superAdmin) {
        return ResponseEntity.ok(superAdminService.createSuperAdmin(superAdmin));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<EzySuperAdmins>> getSuperAdminByEmail(@PathVariable String email) {
        return ResponseEntity.ok(superAdminService.findByEmail(email));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EzySuperAdmins> updateSuperAdmin(@PathVariable Long id, @RequestBody EzySuperAdmins superAdmin) {
        return ResponseEntity.ok(superAdminService.updateSuperAdmin(id, superAdmin));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSuperAdmin(@PathVariable Long id) {
        superAdminService.deleteSuperAdmin(id);
        return ResponseEntity.ok("SuperAdmin deleted with id: " + id);
    }
}
