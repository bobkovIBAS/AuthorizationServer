/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Document(collection = "guestcard")
public class GuestCard {
    @BsonProperty("_id")
    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String id;
    private String name;
    private String surname;
    private String passport;

    public GuestCard(String id, String name, String surname, String pass) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.passport = pass;
    }

    public GuestCard(String name, String surname, String passport) {
        this.name = name;
        this.surname = surname;
        this.passport = passport;
    }

    public GuestCard() {

    }


}
