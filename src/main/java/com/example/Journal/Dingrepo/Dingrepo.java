package com.example.Journal.Dingrepo;
import com.example.Journal.Entity.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Dingrepo extends MongoRepository<Ding, ObjectId > {
    
}
