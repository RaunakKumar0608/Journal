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

    public Ding createDing(Ding ding) {
        return dingrepo.save(ding);
    }

    public Optional<Ding> getDing(ObjectId id) {
        return dingrepo.findById(id);
    }

    public Boolean deleteDing(ObjectId id) {
        if(dingrepo.existsById(id)){
            dingrepo.deleteById(id);
            return true;
        }
     return false;

    }

    public List<Ding> getAll(){
        List<Ding> listOfDing = dingrepo.findAll();
        return listOfDing;
    }

    public boolean deleteAll() {
        dingrepo.deleteAll();
        return true;
    }
    
    public Ding findByTitle(String name){
        return dingrepo.findBytitle(name);
    }

}