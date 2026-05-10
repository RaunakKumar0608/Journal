package com.example.Journal.repositories; 
import org.bson.types.ObjectId;
import com.example.Journal.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, ObjectId> {
    User findByUsername(String username);
}
