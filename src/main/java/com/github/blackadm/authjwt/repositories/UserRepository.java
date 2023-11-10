package com.github.blackadm.authjwt.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.blackadm.authjwt.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
}
