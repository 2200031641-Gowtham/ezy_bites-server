package com.ezy_bites.server.ezy_bitesserver.repo;

import com.ezy_bites.server.ezy_bitesserver.enums.UserRole;
import com.ezy_bites.server.ezy_bitesserver.models.EzyUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EzyUserRepo extends JpaRepository<EzyUsers, Long> {

    Optional<EzyUsers> findByEmail(String email);

    List<EzyUsers> findByRole(UserRole role);

}
