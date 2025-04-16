package com.ezy_bites.server.ezy_bitesserver.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuperAdminLoginResponse {
    private Long id;
    private String email;
    private String name;
}
