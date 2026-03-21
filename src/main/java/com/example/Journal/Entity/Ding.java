package com.example.Journal.Entity;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;


@Document(collection = "Ding")
@Getter
@Setter
public class Ding{
    String name;
    @Id
    ObjectId id;
}