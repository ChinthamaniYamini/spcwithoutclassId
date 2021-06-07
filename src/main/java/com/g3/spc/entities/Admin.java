package com.g3.spc.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class Admin {
//@Id
private int userId;
private String adminName;
private String adminContact;




public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
public Admin(int userId, String adminName, String adminContact) {
	super();
	this.userId = userId;
	this.adminName = adminName;
	this.adminContact = adminContact;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getAdminName() {
	return adminName;
}
public void setAdminName(String adminName) {
	this.adminName = adminName;
}
public String getAdminContact() {
	return adminContact;
}
public void setAdminContact(String adminContact) {
	this.adminContact = adminContact;
}
@Override
public String toString() {
	return "Admin [userId=" + userId + ", adminName=" + adminName + ", adminContact=" + adminContact + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((adminContact == null) ? 0 : adminContact.hashCode());
	result = prime * result + ((adminName == null) ? 0 : adminName.hashCode());
	result = prime * result + userId;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Admin other = (Admin) obj;
	if (adminContact == null) {
		if (other.adminContact != null)
			return false;
	} else if (!adminContact.equals(other.adminContact))
		return false;
	if (adminName == null) {
		if (other.adminName != null)
			return false;
	} else if (!adminName.equals(other.adminName))
		return false;
	if (userId != other.userId)
		return false;
	return true;
}


}
