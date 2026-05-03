package com.example.Journal.service;
import java.util.Arrays;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.Journal.Dingrepo.userrepo;
import com.example.Journal.Entity.User;;

@Service
public class UserService {
       
@Autowired
private userrepo repo;

private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
public void createUser(User user){
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setRoles(Arrays.asList("user"));
    repo.save(user);
}   

public void updateUser(User user){
    repo.save(user);
}

public void deleteUser(ObjectId id){
    repo.deleteById(id);
}

public void deleteUser(String name){
    repo.deleteById(repo.findByusername(name).getId());
}


public List<User> getUsers(){
    return repo.findAll();
}

public User findByusername(String username){
    return repo.findByusername(username);
}

public User findById(ObjectId id){
    return repo.findById(id).orElse(null);
}
}
