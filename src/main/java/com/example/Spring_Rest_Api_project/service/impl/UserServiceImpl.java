package com.example.Spring_Rest_Api_project.service.impl;

import com.example.Spring_Rest_Api_project.model.User;
import com.example.Spring_Rest_Api_project.repository.UserRepository;
import com.example.Spring_Rest_Api_project.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;


    @Override
    public User create(User user) {
        log.info("Create User{}", user);
        return userRepository.save(user);
    }


    @Override
    public User update(User user) {
        log.info("Update User{}", user);
        return userRepository.save(user);
    }


    @Override
    public User getById(Long id) {
        log.info("Get User by Id{}", id);
        return userRepository.getById(id);
    }


    @Override
    public void deleteById(Long id) {
        log.info("Delete User by id{}", id);
        userRepository.deleteById(id);
    }


    @Override
    public List<User> getAll() {
        log.info("Get all Users");
        return userRepository.findAll();
    }
}
