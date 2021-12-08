package com.example.Spring_Rest_Api_project.repository;

import com.example.Spring_Rest_Api_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {

    Optional<User> findByEmail(String email);
}
