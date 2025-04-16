package com.ezy_bites.server.ezy_bitesserver.service;

import com.ezy_bites.server.ezy_bitesserver.models.EzySuperAdmins;

import java.util.Optional;

public interface SuperAdminService {
    EzySuperAdmins createSuperAdmin(EzySuperAdmins superAdmin);

    Optional<EzySuperAdmins> findByEmail(String email);

    EzySuperAdmins updateSuperAdmin(Long id, EzySuperAdmins superAdmin);

    void deleteSuperAdmin(Long id);
}
