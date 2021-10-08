package com.home.curso_spring.domain.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {

        List<User> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new User("orlando", "{noop}12345", new ArrayList<>()));
        listaUsuarios.add(new User("pedro", "{noop}54321", new ArrayList<>()));

        return listaUsuarios.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElseThrow(() -> new UsernameNotFoundException("The user cannot be found."));
    }

}
