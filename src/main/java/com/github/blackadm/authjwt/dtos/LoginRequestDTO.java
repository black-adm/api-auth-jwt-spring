package com.github.blackadm.authjwt.dtos;

import lombok.Data;

@Data
public class LoginRequestDTO {
    
    private String email;
    private String password;
}
