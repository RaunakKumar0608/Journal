package com.example.Journal.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.Journal.Dingrepo.userrepo;
import com.example.Journal.Entity.User;



public class usercontroller{

    @Autowired
    private userrepo userr;

    @PostMapping
    public User createuser(@RequestBody User user) {
           return userr.save(user);
    }
}
