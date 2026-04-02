package com.example.Journal.controller;
import com.example.Journal.Entity.Ding;
import com.example.Journal.Entity.User;
import com.example.Journal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.bson.types.ObjectId;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/journal")
class controller{
    @Autowired
    private service service;
    @Autowired
    private UserService userService;    

    
    @PostMapping("/id/{id}")
    public boolean update(@RequestBody Ding ding , @PathVariable ObjectId id){
        
    Ding data = service.getDing(id).get();
        if(data != null){
            data.setContent(
            ding.getContent());
            data.setTitle(
            ding.getTitle());
            service.createDing(data);   
            return true;
        }
        return false;
    }
    
    @PostMapping("/name/{title}")
    public Ding change(@PathVariable String title, @RequestBody Ding ding){
    Ding data = service.findByTitle(title);
        if(data!=null){
            data.setContent(ding.getContent());
            service.createDing(data);
        }
        return data;
    }

    @GetMapping("/name/{title}")
    public ResponseEntity<Ding> getBytitle(@PathVariable String title){
        return new ResponseEntity<>(service.findByTitle(title), HttpStatus.OK);
    }

    @PostMapping("/{username}")
    public ResponseEntity<Ding> getbody(@RequestBody Ding ding , @PathVariable String username) {
        User user = userService.findByusername(username);
        if(user==null) {
            user = new User();
            user.setUsername(username);
        }
        service.createDing(ding);
        user.getUsersdata().add(ding);
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ding> getDing(@PathVariable ObjectId id) {
        Optional<Ding> Ding = service.getDing(id);
        if(Ding.isPresent())
        return new ResponseEntity<>(
        Ding.get(),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAll/{username}")
    public ResponseEntity<List<Ding>> getDingByUsername(@PathVariable String username){
        User user = userService.findByusername(username);
        if(user != null && user.getUsersdata().size() != 0 ){
            return new ResponseEntity<>(user.getUsersdata(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDing(@PathVariable ObjectId id) {
        if(service.deleteDing(id)) return new ResponseEntity<>(true,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }   
    @GetMapping
    public ResponseEntity<List<Ding>> getAllDing(){
        if(service.getAll().size()==0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(service.getAll(),HttpStatus.ACCEPTED);
    }
    @DeleteMapping
    public boolean deleteAll(){
        service.deleteAll();
        return true;
    }
}