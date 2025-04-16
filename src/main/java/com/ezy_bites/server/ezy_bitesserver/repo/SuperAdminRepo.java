package com.ezy_bites.server.ezy_bitesserver.repo;

import com.ezy_bites.server.ezy_bitesserver.models.EzySuperAdmins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuperAdminRepo extends JpaRepository<EzySuperAdmins, Long> {

    Optional<EzySuperAdmins> findByEmail(String email);


}
