package com.twendee.miniproject1.entity;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Entity
@ToString

@Document(collection = "User")
public class User {

	@Id
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
