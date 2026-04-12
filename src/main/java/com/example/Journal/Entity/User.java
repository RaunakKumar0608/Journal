package com.example.Journal.Entity;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;
import lombok.RequiredArgsConstructor;
@Document(collection = "user")
@Data
@RequiredArgsConstructor
public class User {
    
    @Indexed
    private String username;
    private String password;
    
    @Id
    private ObjectId id;
    @DBRef
    private List<Ding> usersdata = new ArrayList<>();
    private List<String> roles;
}
