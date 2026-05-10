package com.example.Journal.service;
import java.util.Arrays;
import java.util.List;
import org.bson.types.ObjectId;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.Journal.Entity.User;
import com.example.Journal.repositories.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
       
@Autowired
private UserRepo repo;


private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
public boolean createUser(User user){
    try{

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("user"));
        repo.save(user);
        return true;

    }catch(Exception e){

        log.error("error occured for {} :",user.getUsername(),e);
        return false;
    }
}   

public void updateUser(User user){
    repo.save(user);
}

public void deleteUser(ObjectId id){
    repo.deleteById(id);
}

public void deleteUser(String name){
    repo.deleteById(repo.findByUsername(name).getId());
}


public List<User> getUsers(){
    return repo.findAll();
}

public User findByusername(String username){
    return repo.findByUsername(username);
}

public User findById(ObjectId id){
    return repo.findById(id).orElse(null);
}
}
