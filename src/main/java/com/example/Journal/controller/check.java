package com.example.Journal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Journal.Entity.User;

import com.example.Journal.service.UserService;

@RestController
@RequestMapping("/public")
public class check {
     @Autowired
    private UserService userService;

    @PostMapping
    public String createUser(@RequestBody User user) {
            User name1 = userService.findByusername(user.getUsername());
            if(name1 == null){
            userService.createUser(user);
            return "balle balle";
            }
            return "oye teri";
    }

}
