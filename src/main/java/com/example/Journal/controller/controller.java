package com.example.Journal.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Journal.Entity.Ding;
import com.example.Journal.service.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.bson.types.ObjectId;
import java.util.Optional;
import java.util.List;

@RestController
class controller{
    @Autowired
    private service service;
    
    @PostMapping
    public ResponseEntity<Ding> getbody(@RequestBody Ding ding) {
        return new ResponseEntity<>(service.createDing(ding),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ding> getDing(@PathVariable ObjectId id) {
        Optional<Ding> ding = service.getDing(id);
        if(ding.isPresent()) return new ResponseEntity<>(ding.get(),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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