package com.home.curso_spring.domain.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDto {

    private String username;
    private String password;

}
