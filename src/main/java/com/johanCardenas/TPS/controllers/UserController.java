package com.johanCardenas.TPS.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.johanCardenas.TPS.models.User;
import com.johanCardenas.TPS.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping()
    public ArrayList<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
}
