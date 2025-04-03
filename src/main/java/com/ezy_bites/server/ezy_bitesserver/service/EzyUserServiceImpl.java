package com.ezy_bites.server.ezy_bitesserver.service;

import com.ezy_bites.server.ezy_bitesserver.dto.EzyUserDTO;
import com.ezy_bites.server.ezy_bitesserver.models.EzyUsers;
import com.ezy_bites.server.ezy_bitesserver.repo.EzyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EzyUserServiceImpl implements EzyUserService {

    @Autowired
    private EzyUserRepo userRepo;


    @Override
    public List<EzyUsers> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public String postUser(EzyUserDTO user) {
        try{
            EzyUsers newUser = new EzyUsers();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(user.getPassword());
            newUser.setEmail(user.getEmail());
            newUser.setName(user.getName());
            newUser.setPhone(user.getPhone());
            userRepo.save(newUser);
            return "success, ID: " + newUser.getId();
        }catch(Exception e){
            System.err.println(e.getLocalizedMessage());
            return "error";
        }
    }

    @Override
    public String deleteUser(Long id) {
        try{
            userRepo.deleteById(id);
            return "success";
        }catch (Exception e){
            System.err.println(e.getLocalizedMessage());
            return "error";
        }
    }

    @Override
    public String updateUser(Long id, EzyUserDTO user) {
        try {
            EzyUsers existingUser = userRepo.findById(id).orElse(null);
            if (existingUser == null) {
                return "User not found";
            }

            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            existingUser.setName(user.getName());
            existingUser.setPhone(user.getPhone());

            userRepo.save(existingUser);
            return "success";
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
            return "error";
        }
    }

}
