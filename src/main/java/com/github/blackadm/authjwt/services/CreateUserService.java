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

    public User execute(User user) {
        if(this.userRepository.findByEmail(user.getEmail()) != null) throw new Error("Email já possui cadastro no sistema!");

        String hashPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        User createUser = new User(user.getEmail(), hashPassword, user.getRole());

        return userRepository.save(createUser);
    }
}

   