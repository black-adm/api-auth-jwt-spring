package com.github.blackadm.authjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.blackadm.authjwt.entities.User;
import com.github.blackadm.authjwt.repositories.UserRepository;
import com.github.blackadm.authjwt.services.AuthenticationService;
import com.github.blackadm.authjwt.services.CreateUserService;
import com.github.blackadm.authjwt.services.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CreateUserService createUserService;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<User> create(@RequestBody @Valid User user) {
        createUserService.execute(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid User user) {
            String token = authenticationService.findToken(user);
            return ResponseEntity.ok(token);
    }
}
