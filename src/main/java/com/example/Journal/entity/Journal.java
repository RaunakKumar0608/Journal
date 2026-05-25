package com.example.Journal.entity;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Document(collection = "Journal")
@Data
@RequiredArgsConstructor
public class Journal{
    String content;
    String title;
    @Id
    ObjectId id;
}