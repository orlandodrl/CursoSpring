package com.home.curso_spring.web.controller;

import com.home.curso_spring.domain.dto.AuthenticationRequestDto;
import com.home.curso_spring.domain.dto.AuthenticationResponseDto;
import com.home.curso_spring.domain.service.AppUserDetailsService;
import com.home.curso_spring.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AppUserDetailsService userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDto> createToken(@RequestBody AuthenticationRequestDto request){
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            String jwt = jwtUtil.generateToken(userDetails);
            return ResponseEntity.ok().body(new AuthenticationResponseDto(jwt));
        } catch (BadCredentialsException e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

}
