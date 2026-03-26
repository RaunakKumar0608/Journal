package com.example.Journal.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Journal.Entity.User;
import com.example.Journal.service.UserService;
import org.bson.types.ObjectId;
import java.util.List;

@RestController
@RequestMapping("/users")
public class usercontroller{

    @Autowired
    private UserService userService;

    @PostMapping
    public boolean createUser(@RequestBody User user) {
            userService.createUser(user);
            return true;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @PostMapping("/id/{id}")
    public void deleteUser(@PathVariable ObjectId id){
        userService.deleteUser(id);
    }

    @PostMapping("/username/{username}")
    public void update(@PathVariable String username,@RequestBody User user){
        User data = userService.findByusername(username);
        if(data!=null){
            //data.setUsername(data.getUsername());
            data.setPassword(user.getPassword());
            userService.createUser(data);
        }
    }
}
