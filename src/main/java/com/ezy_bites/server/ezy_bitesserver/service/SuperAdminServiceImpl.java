package com.ezy_bites.server.ezy_bitesserver.service;

import com.ezy_bites.server.ezy_bitesserver.exceptions.ResourceNotFoundException;
import com.ezy_bites.server.ezy_bitesserver.models.EzySuperAdmins;
import com.ezy_bites.server.ezy_bitesserver.repo.SuperAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {


    @Autowired
    private SuperAdminRepo superAdminRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public EzySuperAdmins createSuperAdmin(EzySuperAdmins superAdmin) {
        superAdmin.setPasswordHash(passwordEncoder.encode(superAdmin.getPasswordHash()));
        return superAdminRepository.save(superAdmin);
    }

    @Override
    public Optional<EzySuperAdmins> findByEmail(String email) {
        return superAdminRepository.findByEmail(email);
    }

    @Override
    public EzySuperAdmins updateSuperAdmin(Long id, EzySuperAdmins superAdmin) {
        EzySuperAdmins existingSuperAdmin = superAdminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SuperAdmin not found with id: " + id));
        existingSuperAdmin.setEmail(superAdmin.getEmail());
        if (superAdmin.getPasswordHash() != null && !superAdmin.getPasswordHash().isEmpty()) {
            existingSuperAdmin.setPasswordHash(passwordEncoder.encode(superAdmin.getPasswordHash()));
        }
        existingSuperAdmin.setName(superAdmin.getName());
        return superAdminRepository.save(existingSuperAdmin);
    }

    @Override
    public void deleteSuperAdmin(Long id) {
        if (!superAdminRepository.existsById(id)) {
            throw new ResourceNotFoundException("SuperAdmin not found with id: " + id);
        }
        superAdminRepository.deleteById(id);
        System.out.println("Deleted SuperAdmin with id: " + id);
    }
}
