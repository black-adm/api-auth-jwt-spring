package com.github.blackadm.authjwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.blackadm.authjwt.entities.User;
import com.github.blackadm.authjwt.repositories.UserRepository;

@Service
public class CreateUserService {
    
    @Autowired
    UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public User execute(User user) {
        User existUser = userRepository.findByEmail(user.getEmail());

        if (existUser != null) {
            throw new Error("Este email já possui cadastro no sistema");
        }

        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }
}
