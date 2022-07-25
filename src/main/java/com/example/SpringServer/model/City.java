package com.example.SpringServer.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.codecs.pojo.annotations.BsonRepresentation;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "city")
public class City {
    @BsonProperty("_id")
    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String id;
    private String name;
    private int region;

    public City() {
    }

    public City(String id, String name, int region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }

    public City(String name, int region) {
        this.name = name;
        this.region = region;
    }

    @Override
    public String toString() {
        return "City [name=" + name + ", region=" + region + "]";
    }

}
