package com.twendee.scrud.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@ToString
@Entity
@Document(collection = "User")
public class User {
	@Id
	private String id;
	private String name;
	private String birthday;
	private String email;
	private String phone;
	private String description;
	private Binary avatar;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User(String id, String name, String birthday, String email, String phone, String description, Binary avatar) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.email = email;
		this.phone = phone;
		this.description = description;
		this.avatar = avatar;
	}

	public User() {
		
	}
	
	public Binary getAvatar() {
		return avatar;
	}
	public void setAvatar(Binary avatar) {
		this.avatar = avatar;
	}


	
}
