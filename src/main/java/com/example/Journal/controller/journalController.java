package com.example.Journal.controller;

import com.example.Journal.entity.Journal;
import com.example.Journal.entity.User;
import com.example.Journal.service.*;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.bson.types.ObjectId;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/journal")
class JournalController{

    @Autowired
    private JournalService service;

    @Autowired
    private UserService userService;    
    
    @GetMapping
    public ResponseEntity<List<Journal>> getDingByUsername(){
        Authentication authenticate = SecurityContextHolder.getContext().getAuthentication();
        String name = authenticate.getName();
        User user = userService.findByusername(name);
        List<Journal> allEntries = user.getUsersdata();      
        return new ResponseEntity<>(allEntries,HttpStatus.OK);
        }

    @PostMapping
    public ResponseEntity<Journal> create(@RequestBody Journal ding){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByusername(userName);
        Journal data = service.createDing(ding);
        user.getUsersdata().add(data);
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("{id}")
    public boolean update(@RequestBody Journal ding , @PathVariable ObjectId id){  
        Authentication authenticate = SecurityContextHolder.getContext().getAuthentication();
        String userName = authenticate.getName();
        User user = userService.findByusername(userName);
        List<Journal> userData = user.getUsersdata();
        for(Journal ping : userData){
            if(ping.getId().equals(id)){
                
                Journal data = service.findById(ping.getId()).orElse(null);
                try{
                    data.setContent(
                        ding.getContent());
                        data.setTitle(
                            ding.getTitle());
                            service.createDing(data);
                            return true;             
                        }catch(Exception e){
                            log.error("Error ",e);
                        }
            }
        }
        return false;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Journal> getDing(@PathVariable ObjectId id) {
        Authentication authenticate = SecurityContextHolder.getContext().getAuthentication();
        String userName = authenticate.getName();
        User user = userService.findByusername(userName);
        for(Journal ding :user.getUsersdata()){
            if(ding.getId().equals(id)){
                return new ResponseEntity<>(service.findById(id).orElse(null),HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDing(@PathVariable ObjectId id) {
        Authentication authenticate = SecurityContextHolder.getContext().getAuthentication();
        String userName = authenticate.getName();
        User user = userService.findByusername(userName);
        for(Journal journal :user.getUsersdata()){
            if(journal.getId().equals(id)){
                service.deleteDing(id);
                return new ResponseEntity<>(true,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }   

    @DeleteMapping("/deleteAll")
    public boolean deleteAll(){
        service.deleteAll();
        return true;
    }
}