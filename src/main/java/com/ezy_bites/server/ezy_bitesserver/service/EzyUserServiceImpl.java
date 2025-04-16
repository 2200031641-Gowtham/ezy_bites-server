package com.ezy_bites.server.ezy_bitesserver.service;

import com.ezy_bites.server.ezy_bitesserver.enums.UserRole;
import com.ezy_bites.server.ezy_bitesserver.exceptions.ResourceNotFoundException;
import com.ezy_bites.server.ezy_bitesserver.models.EzyUsers;
import com.ezy_bites.server.ezy_bitesserver.repo.EzyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EzyUserServiceImpl implements EzyUserService {

    @Autowired
    private EzyUserRepo userRepo;



    @Override
    public List<EzyUsers> getAllUsers() {
        return List.of();
    }

    @Override
    public String postUser(EzyUsers user) {
        return userRepo.save(user).getEmail();
    }

    @Override
    public String deleteUser(Long id) {
        if (!userRepo.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        userRepo.deleteById(id);
        return "User deleted";
    }

    @Override
    public String updateUser(Long id, EzyUsers user) {
        EzyUsers existingUser = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        existingUser.setEmail(user.getEmail());
        existingUser.setName(user.getName());
        existingUser.setProfilePictureUrl(user.getProfilePictureUrl());
        existingUser.setRole(user.getRole());
        return userRepo.save(existingUser).getEmail();
    }

    @Override
    public Optional<EzyUsers> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public List<EzyUsers> findByRole(UserRole role) {
        return userRepo.findByRole(role);
    }
}
