package com.example.Journal.Dingrepo; 
import org.bson.types.ObjectId;
import com.example.Journal.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface userrepo extends MongoRepository<User, ObjectId> {
    User findByUsername(String username);
}
