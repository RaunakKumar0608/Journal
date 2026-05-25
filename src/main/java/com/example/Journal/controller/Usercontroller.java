package com.example.Journal.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.Journal.service.UserService;
import com.example.Journal.entity.User;
import org.bson.types.ObjectId;
import java.util.List;
    
@RestController
@RequestMapping("/users")
public class Usercontroller{

    @Autowired
    private UserService userService;

    @GetMapping("/id/{id}")
    public User getUser(@PathVariable ObjectId id){
        return userService.findById(id);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @DeleteMapping("/id/{id}")
    public void deleteUser(@PathVariable ObjectId id){
        userService.deleteUser(id);
    }

    @DeleteMapping("/name/{name}")
    public ResponseEntity<User> deleteUser(@PathVariable String name){
        if(userService.findByusername(name)==null) return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
            userService.deleteUser(name);
            return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/id/{id}")
    public ResponseEntity<String> updateUser(@PathVariable ObjectId id, @RequestBody User user){
        User uuser = userService.findById(id);

        if(uuser != null){  
            uuser.setUsername(user.getUsername());
            uuser.setPassword(user.getPassword());
            userService.createUser(uuser);
            return new ResponseEntity<>(uuser.getUsername(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    } 

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user){
         Authentication authenticate = SecurityContextHolder.getContext().getAuthentication();
        
        String name = authenticate.getName();
        User userIndb = userService.findByusername(name);
        User alUser = userService.findByusername(user.getUsername());

        if(alUser == null){
            userIndb.setUsername(user.getUsername());
            userIndb.setPassword(user.getPassword());
            userService.createUser(userIndb);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        if(alUser.getUsername().equals(name)){
             userIndb.setPassword(user.getPassword());
            userService.createUser(userIndb);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}