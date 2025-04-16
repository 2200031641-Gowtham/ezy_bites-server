package com.ezy_bites.server.ezy_bitesserver.controller;


import com.ezy_bites.server.ezy_bitesserver.dto.LoginRequest;
import com.ezy_bites.server.ezy_bitesserver.dto.SuperAdminLoginResponse;
import com.ezy_bites.server.ezy_bitesserver.dto.UserLoginResponse;
import com.ezy_bites.server.ezy_bitesserver.exceptions.ResourceNotFoundException;
import com.ezy_bites.server.ezy_bitesserver.exceptions.UnauthorizedException;
import com.ezy_bites.server.ezy_bitesserver.models.EzySuperAdmins;
import com.ezy_bites.server.ezy_bitesserver.models.EzyUsers;
import com.ezy_bites.server.ezy_bitesserver.service.EzyUserService;
import com.ezy_bites.server.ezy_bitesserver.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private EzyUserService userService;

    @Autowired
    private SuperAdminService superAdminService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/auth/verify")
    public ResponseEntity<UserLoginResponse> verifyUser(@RequestBody String email) {
        EzyUsers user = userService.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));

        UserLoginResponse response = UserLoginResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .profilePictureUrl(user.getProfilePictureUrl())
                .role(user.getRole().name())
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping("/superadmin/login")
    public ResponseEntity<SuperAdminLoginResponse> superAdminLogin(@RequestBody LoginRequest loginRequest) {
        EzySuperAdmins superAdmin = superAdminService.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("SuperAdmin not found with email: " + loginRequest.getEmail()));

        if (!passwordEncoder.matches(loginRequest.getPassword(), superAdmin.getPasswordHash())) {
            throw new UnauthorizedException("Invalid password");
        }

        SuperAdminLoginResponse response = SuperAdminLoginResponse.builder()
                .id(superAdmin.getId())
                .email(superAdmin.getEmail())
                .name(superAdmin.getName())
                .build();

        return ResponseEntity.ok(response);
    }

}
