package com.example.Journal.Dingrepo;
import com.example.Journal.Entity.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Dingrepo extends MongoRepository<Ding, ObjectId > {
    Ding findBytitle(String title);
}
