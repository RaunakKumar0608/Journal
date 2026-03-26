package com.example.Journal.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Document(collection = "Ding")
@Data
@RequiredArgsConstructor
public class Ding{
    String content;
    String title;
    @Id
    ObjectId id;
}