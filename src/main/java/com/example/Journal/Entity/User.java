package com.example.Journal.Entity;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @Indexed(unique = true)
    private String username;
    private String password;
    
    @Id
    private ObjectId id;

    @DBRef
    @Builder.Default
    private List<Journal> usersdata = new ArrayList<>();

    @Builder.Default
    private List<String> roles = new ArrayList<>();
}
