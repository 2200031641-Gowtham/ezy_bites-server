package com.ezy_bites.server.ezy_bitesserver.service;

import com.ezy_bites.server.ezy_bitesserver.dto.EzyUserDTO;
import com.ezy_bites.server.ezy_bitesserver.models.EzyUsers;

import java.util.List;

public interface EzyUserService {

    List<EzyUsers> getAllUsers();
    String postUser(EzyUserDTO user);
    String deleteUser(Long id);
    String updateUser(Long id,EzyUserDTO user);

}
