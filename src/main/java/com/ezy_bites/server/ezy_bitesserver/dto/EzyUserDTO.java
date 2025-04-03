package com.ezy_bites.server.ezy_bitesserver.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EzyUserDTO {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;

}
