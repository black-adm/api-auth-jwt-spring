package com.github.blackadm.authjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.blackadm.authjwt.entities.User;
import com.github.blackadm.authjwt.repositories.UserRepository;
import com.github.blackadm.authjwt.services.CreateUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    CreateUserService createUserService;

    @PostMapping
    public User create(@RequestBody @Valid User user) {
        return createUserService.execute(user);
    }

}
