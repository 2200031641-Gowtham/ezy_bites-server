package com.ezy_bites.server.ezy_bitesserver.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
