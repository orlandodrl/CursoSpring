package com.home.curso_spring.domain.dto;

import lombok.Data;

@Data
public class AuthenticationResponseDto {

    private String jwt;

    public AuthenticationResponseDto(String jwt) {
        this.jwt = jwt;
    }

}
