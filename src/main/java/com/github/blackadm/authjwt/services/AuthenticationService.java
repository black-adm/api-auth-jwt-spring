package com.github.blackadm.authjwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.github.blackadm.authjwt.entities.User;

@Service
public class AuthenticationService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    public String findToken(User user) {
        var userData = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
        var auth = this.authenticationManager.authenticate(userData);
        var token = tokenService.generateToken((User) auth.getPrincipal());

        return token;
    }
}
