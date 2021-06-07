package com.g3.spc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="SCHOOL_USER")
public class User {
	
	
	@Id 
	private  String username;
	private String password;
	private String role;
	 




public User() {
	super();
	// TODO Auto-generated constructor stub
}




public User(String username, String password, String role) {
	super();
	this.username = username;
	this.password = password;
	this.role = role;
}




@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((role == null) ? 0 : role.hashCode());
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	return result;
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




public String getRole() {
	return role;
}




public void setRole(String role) {
	this.role = role;
}




@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (role == null) {
		if (other.role != null)
			return false;
	} else if (!role.equals(other.role))
		return false;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;
	return true;
}




@Override
public String toString() {
	return "User [username=" + username + ", password=" + password + ", role=" + role + "]";
}








}