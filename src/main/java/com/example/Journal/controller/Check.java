package com.example.Journal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Journal.entity.User;

import com.example.Journal.service.UserService;

@RestController
@RequestMapping("/public")

public class Check {

    @Autowired
    private UserService userService;

    @PostMapping
    public boolean createUser(@RequestBody User user) {
            return userService.createUser(user);
        }
}
