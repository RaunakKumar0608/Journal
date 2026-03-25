package com.example.Journal.service;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Journal.Dingrepo.userrepo;
import com.example.Journal.Entity.User;;

@Service
public class UserService {    
@Autowired
private userrepo repo;

public void createUser(User user){
    repo.save(user);
}

public void deleteUser(ObjectId id){
    repo.deleteById(id);
}

public List<User> getUsers(){
    return repo.findAll();
}

public User findByUsername(String username){
    return repo.findByUsername(username);
}
}
