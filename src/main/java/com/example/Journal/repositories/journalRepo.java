package com.example.Journal.repositories;
import com.example.Journal.Entity.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface journalRepo extends MongoRepository<Journal, ObjectId > {
    Journal findBytitle(String title);
}
