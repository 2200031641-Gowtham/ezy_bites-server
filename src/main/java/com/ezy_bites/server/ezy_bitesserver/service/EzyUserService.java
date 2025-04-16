package com.ezy_bites.server.ezy_bitesserver.service;

import com.ezy_bites.server.ezy_bitesserver.dto.EzyUserDTO;
import com.ezy_bites.server.ezy_bitesserver.enums.UserRole;
import com.ezy_bites.server.ezy_bitesserver.models.EzyUsers;

import java.util.List;
import java.util.Optional;

public interface EzyUserService {

    List<EzyUsers> getAllUsers();

    String postUser(EzyUsers user);

    String deleteUser(Long id);

    String updateUser(Long id, EzyUsers user);


    Optional<EzyUsers> findByEmail(String email);

    List<EzyUsers> findByRole(UserRole role);

}
