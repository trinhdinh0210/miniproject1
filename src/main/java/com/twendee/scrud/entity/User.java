package com.twendee.scrud.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

import javax.persistence.Entity;


@ToString
@Entity
@Document(collection = "User")
public class User {

    @Id
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public User() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}