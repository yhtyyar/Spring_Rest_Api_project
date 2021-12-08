package com.example.Spring_Rest_Api_project.service;

import com.example.Spring_Rest_Api_project.model.User;

import java.util.List;

public interface UserService {

    User create(User user);

    User update(User user);

    User getById(Long id);

    void deleteById(Long id);

    List<User> getAll();
}
