package com.example.Journal.service;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.example.Journal.Entity.*;
import com.example.Journal.Dingrepo.*;

@Service
public class service {

    @Autowired
    private Dingrepo dingrepo;

    public Journal createDing(Journal ding) {        
        return dingrepo.save(ding);
    }

    public Optional<Journal> getDing(ObjectId id) {
        return dingrepo.findById(id);
    }

    public Boolean deleteDing(ObjectId id) {
        if(dingrepo.existsById(id)){
            dingrepo.deleteById(id);
            return true;
        }
     return false;

    }

    public List<Journal> getAll(){
        List<Journal> listOfDing = dingrepo.findAll();
        return listOfDing;
    }

    public boolean deleteAll() {
        dingrepo.deleteAll();
        return true;
    }
    
    public Journal findByTitle(String name){
        return dingrepo.findBytitle(name);
    }

    public Optional<Journal> findById(ObjectId id){
        return dingrepo.findById(id);
    }

}