package com.example.demo.controllers;

import com.example.demo.persistance.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    //@PreAuthorize("permitAll()")
    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
