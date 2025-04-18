package com.ezy_bites.server.ezy_bitesserver.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginResponse {
    private Long id;
    private String email;
    private String name;
    private String profilePictureUrl;
    private String role;
}
