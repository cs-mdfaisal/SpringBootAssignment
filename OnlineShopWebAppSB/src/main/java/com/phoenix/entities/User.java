package com.phoenix.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/*
 * @author md.faisal
 * @version 1.0
 * @creation date 02-08-2000
 * @description Persistent class of Hibernate JPA
 */

@Component
@Entity
@Table(name = "LOGIN")
public class User {
	
	@Id
	private String username;
	private String password;
	
public User() {
	// TODO Auto-generated constructor stub
}

public User(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "User [username=" + username + ", password=" + password + "]";
}	

}
