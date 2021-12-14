package com.example.Spring_Rest_Api_project.rest;

import com.example.Spring_Rest_Api_project.model.User;
import com.example.Spring_Rest_Api_project.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class UserRestControllerV1 {


    private final UserServiceImpl userService;


    @PostMapping
    @PreAuthorize("hasAnyAuthority('users:write')")
    public User create(@RequestBody @NonNull User user) {
        return userService.create(user);
    }


    @PutMapping
    @PreAuthorize("hasAnyAuthority('users:write')")
    public User update(@RequestBody @NonNull User user) {
        return userService.update(user);
    }


    @GetMapping
    @PreAuthorize("hasAnyAuthority('users:read')")
    public List<User> getAll() {
        return userService.getAll();
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('users:read')")
    public User getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('users:write')")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

}
